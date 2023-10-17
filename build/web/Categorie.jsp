<%@page import="ma.projet.services.CategorieService"%>
<%@page import="ma.projet.entities.Categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <script>new DataTable('#example');</script>
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
        <form action="CategorieController" onsubmit="return validateForm()">
            <fieldset>
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
                        <tr>
                            <td><input type="submit" value="Ajouter" name="valider" /></td>
                            <td></td>
                        </tr>
               
                </table>

            </fieldset>
        </form>
        
        <fieldset>
            <legend>Liste des catégories</legend>
            <table id="example" border="0">
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Libelle</th>
                        <th>Supprimer</th>
                        <th>Modifier</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        CategorieService cs = new CategorieService();
                      for(Categorie c : cs.findAll()){  
                    %>
                    <tr>
                        <td><%= c.getCode() %></td>
                        <td><%= c.getLibelle() %></td>
                        
                        <td><a href="CategorieController?op=delete&id=<%=c.getId()%>"><button>Supprimer</button></a></td>
                        <td> <button class="button btn-green" onclick="updateCategory(<%=c.getId()%>, '<%=c.getCode()%>', '<%=c.getLibelle()%>')">Modifier</button></td>
                    </tr>
               
                    
                    <%}%>
                </tbody>
            </table>

        </fieldset>
                
    </body>
</html>