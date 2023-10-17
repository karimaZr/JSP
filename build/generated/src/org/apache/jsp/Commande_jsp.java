package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ma.projet.services.LigneCommandeProduitService;
import ma.projet.entities.LigneCommandeProduit;
import ma.projet.entities.Produit;
import ma.projet.services.ProduitService;

public final class Commande_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"CommandeController\" >\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Gestion des commandes</legend>\n");
      out.write("                <table border=\"0\">\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Date: </td>\n");
      out.write("                        <td><input type=date name=\"date\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Produit : </td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"produit\" id=\"produitSelect\">\n");
      out.write("                                ");

                                    ProduitService cs = new ProduitService();
                                    for (Produit p : cs.findAll()) {
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( p.getId());
      out.write("\" data-prix=\"");
      out.print( p.getPrix());
      out.write("\"> ");
      out.print( p.getReference());
      out.write("</option>  \n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"hidden\" name=\"selectedProduit\" id=\"selectedProduit\" value=\"\" />\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Quantité: </td>\n");
      out.write("                        <td><input type=number name=\"quantite\"  /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Total: </td>\n");
      out.write("                        <td><input type=\"number\" name=\"total\" id=\"total\" readonly /></td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("\n");
      out.write("                        <td><input type=\"submit\" value=\"Valider\" name=\"valider\" onclick=\"captureSelectedValue()\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <td></td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </fieldset>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <fieldset>\n");
      out.write("            <legend>Liste des commandes </legend>\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Date</th>\n");
      out.write("                        <th>Produit</th>\n");
      out.write("                        <th>Quantité</th>\n");
      out.write("                        <th>Total</th>\n");
      out.write("                        <th>Supprimer</th>\n");
      out.write("                        <th>Modifier</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        LigneCommandeProduitService lc = new LigneCommandeProduitService();
                        for (LigneCommandeProduit p : lc.findAll()) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( p.getCommande());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( p.getProduit());
      out.write("</td>\n");
      out.write("                        <td> ");
      out.print( p.getQuantite());
      out.write("</td>\n");
      out.write("                        <td> ");
      out.print( p.getTotal());
      out.write("</td>\n");
      out.write("                        <td><a href=\"CommandeController?op=delete&id=");
      out.print(p.getId());
      out.write("\">Supprimer</a></td>\n");
      out.write("                        <td><a href=\"CommandeController?op=update&id=");
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
      out.write("                var select = document.getElementById(\"produitSelect\");\n");
      out.write("                var selectedValue = select.options[select.selectedIndex].value;\n");
      out.write("\n");
      out.write("// Set the selected value in a hidden input field\n");
      out.write("                document.getElementById(\"selectedProduit\").value = selectedValue;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("    // JavaScript function to calculate the total\n");
      out.write("    function calculateTotal() {\n");
      out.write("        var select = document.getElementById(\"produitSelect\");\n");
      out.write("        var quantityInput = document.querySelector(\"input[name='quantite']\");\n");
      out.write("        var totalInput = document.getElementById(\"total\");\n");
      out.write("\n");
      out.write("        var selectedValue = select.options[select.selectedIndex].value;\n");
      out.write("        var selectedOption = select.options[select.selectedIndex];\n");
      out.write("        var prix = parseFloat(selectedOption.getAttribute(\"data-prix\"));\n");
      out.write("        var quantite = parseFloat(quantityInput.value);\n");
      out.write("\n");
      out.write("        if (!isNaN(prix) && !isNaN(quantite)) {\n");
      out.write("            var total = prix * quantite;\n");
      out.write("            totalInput.value = total;\n");
      out.write("        } else {\n");
      out.write("            totalInput.value = \"\";\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    // Attach the event listener to detect changes in quantity or product selection\n");
      out.write("    document.querySelector(\"input[name='quantite']\").addEventListener(\"input\", calculateTotal);\n");
      out.write("    document.getElementById(\"produitSelect\").addEventListener(\"change\", calculateTotal);\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
