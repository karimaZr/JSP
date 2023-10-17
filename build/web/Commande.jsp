<%-- 
    Document   : Produit
    Created on : Oct 8, 2023, 3:07:04 PM
    Author     : hp
--%>

<%@page import="ma.projet.services.LigneCommandeProduitService"%>
<%@page import="ma.projet.entities.LigneCommandeProduit"%>
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
        <form action="CommandeController" >
            <fieldset>
                <legend>Gestion des commandes</legend>
                <table border="0">

                    <tr>
                        <td> Date: </td>
                        <td><input type=date name="date" value="" /></td>
                    </tr>
                    <tr>
                        <td> Produit : </td>
                        <td>
                            <select name="produit" id="produitSelect">
                                <%
                                    ProduitService cs = new ProduitService();
                                    for (Produit p : cs.findAll()) {
                                %>
                                <option value="<%= p.getId()%>" data-prix="<%= p.getPrix()%>"> <%= p.getReference()%></option>  
                                <%}%>
                            </select>
                            <input type="hidden" name="selectedProduit" id="selectedProduit" value="" />

                        </td>

                    </tr>
                    <tr>
                        <td> Quantité: </td>
                        <td><input type=number name="quantite"  /></td>
                    </tr>
                    <tr>
                        <td> Total: </td>
                        <td><input type="number" name="total" id="total" readonly /></td>


                    </tr>

                    <tr>

                        <td><input type="submit" value="Valider" name="valider" onclick="captureSelectedValue()" />


                        <td></td>
                    </tr>

                </table>

            </fieldset>
        </form>

        <fieldset>
            <legend>Liste des commandes </legend>
            <table border="0">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Produit</th>
                        <th>Quantité</th>
                        <th>Total</th>
                        <th>Supprimer</th>
                        <th>Modifier</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        LigneCommandeProduitService lc = new LigneCommandeProduitService();
                        for (LigneCommandeProduit p : lc.findAll()) {
                    %>
                    <tr>
                        <td><%= p.getCommande()%></td>
                        <td><%= p.getProduit()%></td>
                        <td> <%= p.getQuantite()%></td>
                        <td> <%= p.getTotal()%></td>
                        <td><a href="CommandeController?op=delete&id=<%=p.getId()%>">Supprimer</a></td>
                        <td><a href="CommandeController?op=update&id=<%=p.getId()%>">Modifier</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>


        </fieldset>
        <script>
// JavaScript function to capture the selected value
            function captureSelectedValue() {
                var select = document.getElementById("produitSelect");
                var selectedValue = select.options[select.selectedIndex].value;

// Set the selected value in a hidden input field
                document.getElementById("selectedProduit").value = selectedValue;
            }
            
        </script>
        <script>
    // JavaScript function to calculate the total
    function calculateTotal() {
        var select = document.getElementById("produitSelect");
        var quantityInput = document.querySelector("input[name='quantite']");
        var totalInput = document.getElementById("total");

        var selectedValue = select.options[select.selectedIndex].value;
        var selectedOption = select.options[select.selectedIndex];
        var prix = parseFloat(selectedOption.getAttribute("data-prix"));
        var quantite = parseFloat(quantityInput.value);

        if (!isNaN(prix) && !isNaN(quantite)) {
            var total = prix * quantite;
            totalInput.value = total;
        } else {
            totalInput.value = "";
        }
    }

    // Attach the event listener to detect changes in quantity or product selection
    document.querySelector("input[name='quantite']").addEventListener("input", calculateTotal);
    document.getElementById("produitSelect").addEventListener("change", calculateTotal);
</script>


    </body>
</html>
