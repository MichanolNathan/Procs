<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
    <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="modele.Entreprise"%>
<%@ page import="modele.Contact"%>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script
			  src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			  integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g="
			  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.js"></script>
<title><bean:message key="title"/></title>
</head>
<body>

<div class="ui large menu">
  <a href="/Contact" class="item"><bean:message key="home"/></a>
  <a href="Home.do" class="item"><bean:message key="contacts"/></a>
  <div class="right menu">159715975385253852
   	<div class="item">
   		<% if (session.getAttribute("user") != null) { %>
   			<div class="ui dropdown item"><%= session.getAttribute("user") %> <i class="dropdown icon"></i>
      		<div class="menu">
		        <a class="item" href="Logout.do"><bean:message key="link.logout"/></a>
	      	</div>
    	</div>
		<%} else {%>
			<div class="item">
	        	<a href="Connection.do" class="ui primary button"><bean:message key="link.signin"/></a>
	    	</div>
	    	<% } 
   				Contact contact = (Contact) request.getAttribute("contact");
	    	%>
		
   </div>
  </div>
</div>

<div class="ui container">
   <html:form method="post" action="EditContact.do" styleClass="ui form error">
   		<html:hidden name="contact" property="id"/>
   		<h4 class="ui dividing header"><bean:message key="form.contact"/></h4>
   		<div class="two fields">
   			<div class="field">
		   		<label for="lastName"><bean:message key="form.contact.lastName.label"/></label>
				<html:text name="contact" property="lastName" size="45" maxlength="45" styleId="lastName"/>
				<div class="ui error message">
    				<p><html:errors property="lastName"/></p>
  				</div>
			</div>
			<div class="field">
				<label for="firstName"><bean:message key="form.contact.firstName.label"/></label>
				<html:text name="contact" property="firstName" size="50" maxlength="50" styleId="firstName"/>
				<div class="ui error message">
    				<p><html:errors property="firstName"/></p>
  				</div>
			</div>
		</div>
		<div class="twelve wide field">
			<label for="username"><bean:message key="form.contact.email.label"/></label>
			<html:text name="contact" property="email" size="75" maxlength="75" styleId="email"/>
			<div class="ui error message">
   				<p><html:errors property="email"/></p>
			</div>
		</div>
		<h4 class="ui dividing header"><bean:message key="form.contact.adress"/></h4>
		<bean:define id="adresse" name="contact" property="adresse"/>
		<input type="hidden" name="idAdress" value="<bean:write name="adresse" property="idAdress"/>">
		<div class="two fields">
			<div class="field">
				<label for="country"><bean:message key="form.contact.country.label"/></label>
				<html:text name="adresse" property="country" size="50" maxlength="50" styleId="country"/>
				<div class="ui error message">
	   				<p><html:errors property="country"/></p>
				</div>
			</div>
			<div class="field">
				<label for="city"><bean:message key="form.contact.city.label"/></label>
				<html:text name="adresse" property="city" size="50" maxlength="50" styleId="city"/>
				<div class="ui error message">
	   				<p><html:errors property="city"/></p>
				</div>
			</div>
		</div>
		<div class="fields">
			<div class="three wide field">
				<label for="zip"><bean:message key="form.contact.zip.label"/></label>
				<html:text name="adresse" property="zip" size="50" maxlength="50" styleId="zip"/>
				<div class="ui error message">
	   				<p><html:errors property="zip"/></p>
				</div>
			</div>
			<div class="thirteen wide field">
				<label for="street"><bean:message key="form.contact.street.label"/></label>
				<html:text name="adresse" property="street" size="50" maxlength="50" styleId="street"/>
				<div class="ui error message">
	   				<p><html:errors property="street"/></p>
				</div>
			</div>
		</div>
<h4 class="ui dividing header"><bean:message key="form.contact.phone"/></h4>
		<logic:iterate name="phoneNumbers" id="phone">
			<input type="hidden" name="idPhone" value="<bean:write name="phone" property="id"/>">
			<div class="fields">
				<div class="three wide field">
					<label for="phoneKind"><bean:message key="form.contact.phoneKind.label"/></label>
					<html:text name="phone" property="phoneKind" size="10" maxlength="10" styleId="phoneKind"/>
					<div class="ui error message">
		   				<p><html:errors property="phoneKind"/></p>
					</div>
				</div>
				<div class="six wide field">
					<label for="phoneNumber"><bean:message key="form.contact.phoneNumber.label"/></label>
					<html:text name="phone" property="phoneNumber" size="15" maxlength="15" styleId="phoneNumber"/>
					<div class="ui error message">
		   				<p><html:errors property="phoneNumber"/></p>
					</div>
				</div>
			</div>
		</logic:iterate>
		<h4 class="ui dividing header"><bean:message key="form.contact.group"/></h4>
		<bean:define id="contactGroups" name="contact" property="groups"/>
		<div class="six wide field">
			<html:select property="groups" multiple="" styleClass="ui fluid dropdown">
				<html:optionsCollection name="listGroups" value="id" label="groupName"/>
			</html:select>
			<div class="ui error message">
   				<p><html:errors property="groups"/></p>
			</div>
		</div>
		<% if(Entreprise.class.isInstance(contact)) { %>
			<h4 class="ui dividing header"><bean:message key="form.contact.entreprise"/></h4>
			<div class="two fields">
				<div class="field">
					<label for="numSiret">Num Siret de l'entreprise</label>
					<html:text name="contact" property="numSiret" size="14" maxlength="14"/>
					<div class="ui error message">
	    				<p><html:errors property="numSiret"/></p>
	  				</div>
				</div>
				<div class="field">
					<label for="name">Nom de l'entreprise</label>
					<html:text name="contact" property="name" size="50" maxlength="50"/>
					<div class="ui error message">
	    				<p><html:errors property="name"/></p>
	  				</div>
				</div>
			</div>
		<% } %>
		<html:submit styleClass="ui button"><bean:message key="form.contact.edit"/></html:submit>
   </html:form> 
</div>

<script>
$(document).ready(function ()
{
	
	<logic:iterate name="contactGroups" id="group">
	console.log($('select[name="groups"] option[value="<bean:write name="group" property="id"/>"]'));
	$('select[name="groups"] option[value="<bean:write name="group" property="id"/>"]').attr('selected','selected');
	</logic:iterate>
	
	$('.ui.dropdown')
	  .dropdown()
	;
	
	var errors = $(".form .error");
	var count = 0;
	errors.each(function()
	{
		if ($(this).children("p").html() == "")
		{
			$(this).css("display", "none");
		}
		else
		{
			var count = 1;
		}
	})
	if (count == 1)
	{
		$(".form").addClass("error");
	}
});
</script>

</body>
</html:html>