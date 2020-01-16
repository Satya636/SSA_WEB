<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Citizen Details || SSN-WEB</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

<script type="text/javascript">
	function validateform() {
		var fname = document.registerForm.fname.value;
		var lname = document.registerForm.lname.value;
		var phno = document.registerForm.phNo.value;

		if (fname == null || fname == "") {
			Swal.fire("FirstName Can't Be Blank !!!");
			return false;
		} else if (lname == null || lname == "") {
			Swal.fire("LastName Can't Be Blank !!!");
			return false;
		} else if (phno == null || phno == "") {
			Swal.fire("PhoneNo Can't Be Blank !!!");
			return false;
		} else {
			showMessage();
		}
	}
</script>

<body background="images/usa.jpg">
	<h2 style="color: white; text-align: center;">Citizen Details</h2>
	
	                <center><font color="green">${success}</font></center>
	                 <center><font color="red">${failure}</font></center>
	
	<form:form name="registerForm" action="submitBtn" method="POST" modelAttribute="cInfo">

		<table  align="center">
			<tr>
				<td style="color: white">First Name</td>
				<td><form:input path="fname" /></td>
			</tr>

			<tr>
				<td style="color: white">Last Name</td>
				<td><form:input path="lname" /></td>
			</tr>
			<tr>
				<td style="color: white">Dob</td>
				<td><form:input path="dob" type="date" /></td>
			</tr>
			<tr>
				<td style="color: white">Gender</td>
				<td><form:radiobutton path="gender" value="male" /><font color="white">Male</font><form:radiobutton
						path="gender" value="female" /><font color="white">Female</font></td>
			</tr>
			<tr>
				<td style="color: white">State</td>
				<td><form:select path="state">
						<form:option value="">-Select A State-</form:option>
						<form:options items="${states}" />
					</form:select></td>
			</tr>

			<tr>

				  <td colspan="2"><center><input type="submit" value="Submit"></center></td>
			</tr>
		</table>












	</form:form>



</body>
</html>