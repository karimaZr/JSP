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
         <style>

            legend {
                font-size: 1.2em;
                font-weight: bold;
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }

            table, th, td {
                border: 1px solid #ddd;
            }

            th, td {
                padding: 10px;
                text-align: left;
            }

            /* Styles pour les boutons */
            input[type="submit"] {
                background-color: #007BFF;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
            }

            /* Styles pour les liens de suppression et de modification */
            a {
                text-decoration: none;
                color: #007BFF;
            }

            a:hover {
                text-decoration: underline;
            }

            /* Styles pour le tableau des produits */
            #example1 {
                margin: 20px;
                border-collapse: collapse;
                width: 100%;
            }

            #example1 th, #example1 td {
                border: 1px solid #ddd;
                padding: 10px;
                text-align: left;
            }

            /* Styles for fieldsets */
            /* Styles for fieldsets */
            /* Styles for the container that holds the fieldsets */
            .fieldset-container {
                display: flex;
                justify-content: space-between; /* Space the fieldsets at each end */
                 background-color: #fff;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                display: flex;
                justify-content: space-between; 
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            /* Styles for fieldsets */
            fieldset#gestion-fieldset {
                border: 1px solid #ccc;
                border-radius: 5px;
                padding: 10px;
                width: 30%; /* Set a width for the gestion-fieldset */
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            fieldset#liste-fieldset {
                border: 1px solid #ccc;
                border-radius: 5px;
                padding: 10px;
                width: 70%; /* Set a wider width for the liste-fieldset */
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }








        </style>
    </head>
    <body>
        <div class="fieldset-container">
            <form action="ProduitController"  >
                <fieldset id="gestion-fieldset">
                    <legend>Gestion des produits</legend>
                    <table border="0">

                        <tr>
                            <td>Référence: </td>
                            <td><input type="text" name="reference"  /></td>
                        </tr>
                        <tr>
                            <td>Prix : </td>
                            <td><input type="number" name="prix"  /></td>
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

                            <td><input type="submit" value="Valider" name="valider" onclick="captureSelectedValue()" />
                            </td>
                        </tr>

                    </table>

                </fieldset>
            </form>

            <fieldset  id="liste-fieldset">
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
                            <td><a href="ProduitController?op=delete&id=<%=p.getId()%>">Supprimer</a></td>
                            <td><a href="CategorieController?op=update&id=<%=p.getId()%>">Modifier</a></td>
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
        </div>
    </body>
</html>