<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.entities.Categorie"%>
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
        <script>

            function validateForm() {
                var code = document.getElementsByName("code")[0].value;
                var id = document.getElementsByName("id")[0].value;


                // Vérifier la valeur du bouton "valider"
                if (valider === "Modifier") {
                    // Si le bouton est "Modifier", rediriger avec l'ID
                    console.log(id);
                    window.location.href = "CategorieController?op=update&id=" + id + "&code=" + code + "&libelle=" + libelle;
                    ;
                    return false; // Empêcher la soumission du formulaire
                } else if (valider === "Ajouter") {
                    // Si le bouton est "Ajouter", permettre la soumission du formulaire
                    return true;
                }

                // Si aucune des conditions précédentes n'est satisfaite, par défaut, empêcher la soumission du formulaire
                return false;
            }


            function updateCategory(id, code, libelle) {
                // Pre-fill the code and libelle fields with the category data
                document.getElementsByName("code")[0].value = code;
                document.getElementsByName("libelle")[0].value = libelle;
                document.getElementsByName("id")[0].value = id;
                document.getElementsByName("valider")[0].value = "Modifier";
            }

        </script>
        <div class="fieldset-container">
            <form action="CategorieController" onsubmit="return validateForm()">

                <fieldset id="gestion-fieldset">

                    <legend>Gestion des catégories</legend>
                    <table border="0">

                        <tr>
                            <td>Code: </td>
                            <td><input type="text" name="code" value="" /></td>
                            <td style="display: none;"><input type="text" name="id" value="" hidden/></td>
                        </tr>
                        <tr>
                            <td>Libelle : </td>
                            <td><input type="text" name="libelle" value="" /></td>
                        </tr>

                        <td><input type="submit" value="Ajouter" name="valider" /></td>



                    </table>
            </form>

                </fieldset>


                <fieldset id="liste-fieldset">
                    <legend>Liste des catégories</legend>
                    <table id="example" border="0">
                        <thead>
                            <tr>
                                <th>Code</th>
                                <th>Libelle</th>
                                <th>Actions</th>
                                

                            </tr>
                        </thead>
                        <tbody>
                            <%
                                CategorieService cs = new CategorieService();
                                for (Categorie c : cs.findAll()) {
                            %>
                            <tr>
                                <td><%= c.getCode()%></td>
                                <td><%= c.getLibelle()%></td>

                                
                                <td><a href="CategorieController?op=delete&id=<%=c.getId()%>"><button>Supprimer</button></a>
                                  <button class="button btn-green" name="valider" value="Modifier" onclick="updateCategory(<%=c.getId()%>, '<%=c.getCode()%>', '<%=c.getLibelle()%>')">Modifier</button></td>
                            </tr>


                            <%}%>
                        </tbody>
                    </table>

                </fieldset>
            
        </div>
    </body>
</html>