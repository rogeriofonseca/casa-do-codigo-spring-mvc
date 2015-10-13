<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Cadastro de Produtos</title>
</head>
<body>
  <form method="post" action="/casadocodigo/produtos">
    <div>
        <label for="title">Titulo</label>
        <input type="text" name="title" id="title"/>
    </div>
    <div>
        <label for="description">Descrição</label>
        <textarea rows="10" cols="20" name="description" id="description"></textarea>
    </div> <div>
        <label for="pages">Número de paginas</label>
        <input type="text" name="pages" id="pages"/>
    </div>
    <div>
        <input type="submit" value="Enviar">
    </div>
  </form>
</body>
</html>
