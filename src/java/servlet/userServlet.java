package servlet;

import data.splash;
import data.user;
import handlers.splashHandler;
import handlers.userHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class userServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mode = request.getParameter("mode");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        userHandler handler = new userHandler();
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        user u = null;

        switch (mode) {
            case "reg":
                String name = request.getParameter("name");
                Part profile = request.getPart("file");

                if (profile != null) {

                    String orgFileName = name + "_" + Paths.get(profile.getSubmittedFileName()).getFileName().toString();
                    InputStream fileStream = profile.getInputStream();

                    ServletContext context = getServletContext();
                    String webPath = context.getRealPath("") + "/../../web/userImages";

                    String fileName = webPath + "/" + orgFileName;

                    File f = new File(fileName);

                    byte[] fileBuffer = new byte[fileStream.available()];
                    fileStream.read(fileBuffer);

                    OutputStream outStream = new FileOutputStream(f);
                    outStream.write(fileBuffer);

                    boolean result = handler.register(name, pass, email, "userImages/" + orgFileName);
                    if (result) {
                        rd = request.getRequestDispatcher("/home");
                    }

                }
                break;

            case "login":
                u = handler.login(email, pass);

                if (u != null) {
                    request.getSession().setAttribute("user", u);
                    rd = request.getRequestDispatcher("/home");
                }

                break;

            case "prof":
                String currentProfile = request.getParameter("current");

                if (currentProfile == null) {
                    currentProfile = "";
                }

                boolean current = false;

                if (currentProfile.equals("y")) {
                    current = true;
                    u = (user) request.getSession().getAttribute("user");
                } else {
                    int userID = Integer.valueOf(request.getParameter("ID"));

                    try {
                        user tempU = (user) request.getSession().getAttribute("user");

                        if (tempU.getID() == userID) {
                            u = tempU;
                            current = true;
                        }
                    } catch (Exception e) {
                    }

                    if (!current) {
                        u = handler.getUserByID(userID);
                    }

                }

                splashHandler sHandler = new splashHandler();
                List<splash> sList = sHandler.getUserSplashes(u.getID());

                request.setAttribute("splashes", sList);
                request.setAttribute("profUser", u);
                request.setAttribute("current", current);
                rd = request.getRequestDispatcher("profile.jsp");

                break;

            case "logout":
                request.getSession().setAttribute("user", null);
                rd = request.getRequestDispatcher("home");

        }

        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
