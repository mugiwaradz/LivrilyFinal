<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<div id="container">
        <form method="post" commandName="todo">
            <label for="livreur_id">Login:</label>
            <input type="text" id="livreur_id" name="livreur_id">
            <label for="commande_id">Password:</label>
            <input type="text" id="commande_id" name="commande_id">
            <div id="lower">
                <input type="submit" value="add">
            </div><!--/ lower-->
        </form>
    </div><!--/ container-->
</div>
<%@ include file="common/footer.jspf" %>