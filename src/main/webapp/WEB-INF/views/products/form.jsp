<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Cadastro de Produtos</title>
</head>
<body>
  <form method="post" action="/casadocodigo/produtos">
    <div>
        <label for="title">T�tulo</label>
        <input type="text" name="title" id="title"/>
    </div>
    <div>
        <label for="description">Descri��o�o</label>
        <textarea rows="10" cols="20" name="description" id="description"></textarea>
    </div> <div>
        <label for="pages">N�mero de p�ginas</label>
        <input type="text" name="pages" id="pages"/>
    </div>
    <div>
        <input type="submit" value="Enviar">
    </div>
  </form>
</body>
</html>
