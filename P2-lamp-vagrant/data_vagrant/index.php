<?php 
    $conexion = new mysqli('localhost','root','P@ssw0rd','BD_SistGestion');
    
    if($conexion->connect_error){
    	die('Error en la conexion' . $conexion->connect_error);
    }  
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset = "UTF-8"> 
        <title>Países</title>
    </head>
    <body>
        <p>probando</p>
<br><br>
        <table border = "1">
            <td>nombre</td>      
        <?php 
		$sql="SELECT * from paises";
		$result=mysqli_query($conexion,$sql);

		while($row=mysqli_fetch_assoc($result)){
		 ?>

		<tr>
			<td><?php echo $row["nombre"] ?></td>
		</tr>
	    <?php 
	    }
	    ?>
        </table>
    </body>
</html>

