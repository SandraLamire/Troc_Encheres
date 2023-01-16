<%@ page contentType="text/html;charset=UTF-8" %>
<form id="form_update_profile" method="post" action="${pageContext.request.contextPath}/updateProfile" class="ml-1 ml-md-5">
    <%@include file="/WEB-INF/jsp/userForm.jsp"%>
    <div class="form-group row" id="new_password_block">
        <label class="col-form-label col-md-1" for="current_password">Mot de passe actuel</label>
        <div class="col-md-4">
            <input required type="password" class="form-control" name="current_password" id="current_password" placeholder="Mot de passe">
        </div>
    </div>
    <div class="form-group row" id="new_password_block">
        <label class="col-form-label col-md-1" for="new_password">Nouveau mot de passe</label>
        <div class="col-md-4">
            <input type="password" class="form-control" name="new_password" id="new_password" placeholder="Mot de passe">
        </div>
        <label class="col-form-label offset-md-1 col-md-1" for="confirm_new_password">Confirmation</label>
        <div class="col-md-4">
            <input type="password" class="form-control" name="confirm_new_password" id="confirm_new_password" placeholder="Répétez le mot de passe">
        </div>
    </div>
    <div class="row mt-md-5">
        <div class="col-3 col-md-1">Crédits</div>
        <div class="col-3 col-md-1"><jsp:getProperty name="userSession" property="credit"/></div>
    </div>
    <%@include file="/WEB-INF/jsp/displayErrors.jsp"%>
    <div class="row mt-3 mt-md-5">
        <input type="submit" value="Modifier" class="offset-1 col-10 offset-md-2 col-md-3 btn btn-success btn-block mb-2">
        <a href="${pageContext.request.contextPath}/deleteProfile" class="offset-1 col-10 offset-md-1 col-md-3 p-0">
            <button type="button" class="btn btn-danger btn-block">Supprimer mon compte</button>
        </a>
    </div>
</form>
<script type="text/javascript">
    $("#form_update_profile").on("submit", function(e) {
        if ($("#new_password").val() !== $("#confirm_new_password").val()) {
            e.preventDefault();
            var passwordNotMatchWarning = $('<p class="mx-auto text-danger">Les mots de passe ne correspondent pas</p>');
            $("#new_password_block").append(passwordNotMatchWarning);
        }
    });
</script>