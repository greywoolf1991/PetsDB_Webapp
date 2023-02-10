<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit pet</title>
</head>
<body>
<h3>Edit pet</h3>
<form method="post">
    <input type="hidden" value="${pet.id}" name="id" />
    <label>Type</label>
    <br>
    <input name="type" value="${pet.type}" />
    <br>
    <br>
    <label>Name</label>
    <br>
    <input name="name" value="${pet.name}" />
    <br>
    <br>
    <input type="submit" value="Send" />
</form>
</body>
</html>