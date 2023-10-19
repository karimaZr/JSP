package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ma.projet.entities.Categorie;
import ma.projet.services.CategorieService;
import ma.projet.entities.Produit;
import ma.projet.services.ProduitService;

public final class Produit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            /* Styles pour le formulaire de gestion des produits */\n");
      out.write("            form {\n");
      out.write("                margin: 20px;\n");
      out.write("                background-color: #fff;\n");
      out.write("                padding: 20px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            legend {\n");
      out.write("                font-size: 1.2em;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table {\n");
      out.write("                width: 100%;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table, th, td {\n");
      out.write("                border: 1px solid #ddd;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            th, td {\n");
      out.write("                padding: 10px;\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Styles pour les boutons */\n");
      out.write("            input[type=\"submit\"] {\n");
      out.write("                background-color: #007BFF;\n");
      out.write("                color: #fff;\n");
      out.write("                border: none;\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"submit\"]:hover {\n");
      out.write("                background-color: #0056b3;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Styles pour les liens de suppression et de modification */\n");
      out.write("            a {\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: #007BFF;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            a:hover {\n");
      out.write("                text-decoration: underline;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Styles pour le tableau des produits */\n");
      out.write("            #example1 {\n");
      out.write("                margin: 20px;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #example1 th, #example1 td {\n");
      out.write("                border: 1px solid #ddd;\n");
      out.write("                padding: 10px;\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Ajoutez ici d'autres styles personnalisés si nécessaire */\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"ProduitController\"  >\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Gestion des produits</legend>\n");
      out.write("                <table border=\"0\">\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Référence: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"reference\"  /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Prix : </td>\n");
      out.write("                        <td><input type=\"number\" name=\"prix\"  /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Catégorie : </td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"Catégorie\" id=\"categorieSelect\">\n");
      out.write("                                ");

                                    CategorieService cs = new CategorieService();
                                    for (Categorie c : cs.findAll()) {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( c.getId());
      out.write("\"> ");
      out.print( c.getLibelle());
      out.write("</option>  \n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"hidden\" name=\"selectedCategorie\" id=\"selectedCategorie\" value=\"\" />\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("\n");
      out.write("                        <td><input type=\"submit\" value=\"Valider\" name=\"valider\" onclick=\"captureSelectedValue()\" />\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </fieldset>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <fieldset>\n");
      out.write("            <legend>Liste des produits</legend>\n");
      out.write("            <table border=\"0\" id=\"example1\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Référence</th>\n");
      out.write("                        <th>Prix</th>\n");
      out.write("                        <th>Catégorie</th>\n");
      out.write("                        <th>Supprimer</th>\n");
      out.write("                        <th>Modifier</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        ProduitService ps = new ProduitService();
                        for (Produit p : ps.findAll()) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( p.getReference());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( p.getPrix());
      out.write("</td>\n");
      out.write("                        <td> ");
      out.print( p.getCategorie());
      out.write("</td>\n");
      out.write("                        <td><a href=\"ProduitController?op=delete&id=");
      out.print(p.getId());
      out.write("\">Supprimer</a></td>\n");
      out.write("                        <td><a href=\"CategorieController?op=update&id=");
      out.print(p.getId());
      out.write("\">Modifier</a></td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </fieldset>\n");
      out.write("        <script>\n");
      out.write("// JavaScript function to capture the selected value\n");
      out.write("            function captureSelectedValue() {\n");
      out.write("                var select = document.getElementById(\"categorieSelect\");\n");
      out.write("                var selectedValue = select.options[select.selectedIndex].value;\n");
      out.write("\n");
      out.write("// Set the selected value in a hidden input field\n");
      out.write("                document.getElementById(\"selectedCategorie\").value = selectedValue;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
