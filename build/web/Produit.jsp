<%-- 
    Document   : Produit
    Created on : Oct 8, 2023, 3:07:04 PM
    Author     : hp
--%>

<%@page import="ma.projet.entities.Categorie"%>
<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.entities.Produit"%>
<%@page import="ma.projet.services.ProduitService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script>
    function validateForm() {
        var prix = document.getElementsByName("prix")[0].value;
        var ref = document.getElementsByName("reference")[0].value;
        var categorie = document.getElementsByName("categorie")[0].value;
        var id = document.getElementsByName("id")[0].value;
        var valider = document.getElementsByName("valider")[0].value;

    
        // Vérifier la valeur du bouton "valider"
        if (valider === "Modifier") {  
            window.location.href="CategorieController?op=update&id="+ id; 
            
            return false; // Empêcher la soumission du formulaire
        } else if (valider === "Ajouter") {
            // Si le bouton est "Ajouter", permettre la soumission du formulaire
            return true;
        }

        // Si aucune des conditions précédentes n'est satisfaite, par défaut, empêcher la soumission du formulaire
        return false;
    }

    

    function updateProduit(id, ref, prix, categorie) {
        document.getElementsByName("prix")[0].value = prix;
        document.getElementsByName("reference")[0].value = reference;
        document.getElementById("selectedCategorie").value = selectedValue;
        document.getElementsByName("id")[0].value = id;
        document.getElementsByName("valider")[0].value = "Modifier";
    }
    
    
</script>
        <form action="ProduitController" onsubmit="return validateForm()"  >
            <fieldset>
                <legend>Gestion des produits</legend>
                <table border="0">

                    <tr>
                        <td>Référence: </td>
                        <td><input type="text" name="reference" value="" /></td>
                        <td><input type="text" name="id" value="" hidden/></td>
                    </tr>
                    <tr>
                        <td>Prix : </td>
                        <td><input type="number" name="prix" value="" /></td>
                    </tr>
                    <tr>
                        <td>Catégorie : </td>
                        <td>
                    <select name="Catégorie" id="categorieSelect">
                        <%
                            CategorieService cs = new CategorieService();
                            for (Categorie c : cs.findAll()) {
                        %>
                        <option value="<%= c.getId()%>"> <%= c.getLibelle()%></option>  
                        <%}%>
                    </select>
                      <input type="hidden" name="selectedCategorie" id="selectedCategorie" value="" />

                        </td>

                    </tr>

                    <tr>
                        
                        <td><input type="submit" value="ajouter" name="valider" onclick="captureSelectedValue()" />
</td>
                        
                        <td></td>
                    </tr>

                </table>

            </fieldset>
        </form>

        <fieldset>
            <legend>Liste des produits</legend>
            <table border="0" id="example1">
                <thead>
                    <tr>
                        <th>Référence</th>
                        <th>Prix</th>
                        <th>Catégorie</th>
                        <th>Supprimer</th>
                        <th>Modifier</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ProduitService ps = new ProduitService();
                        for (Produit p : ps.findAll()) {
                    %>
                    <tr>
                        <td><%= p.getReference()%></td>
                        <td><%= p.getPrix()%></td>
                        <td> <%= p.getCategorie()%></td>
                        <td><a href="ProduitController?op=delete&id=<%=p.getId()%>"><button>Supprimer</button></a></td>
                        <td><button type="button" onclick="updateProduit(<%=p.getId()%>, '<%=p.getReference()%>', <%=p.getPrix()%>,<%= p.getCategorie().getId()%>)">Modifier</button></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>


        </fieldset>
        <script>
// JavaScript function to capture the selected value
            function captureSelectedValue() {
                var select = document.getElementById("categorieSelect");
                var selectedValue = select.options[select.selectedIndex].value;

// Set the selected value in a hidden input field
                document.getElementById("selectedCategorie").value = selectedValue;
            }
        </script>

    </body>
</html>
