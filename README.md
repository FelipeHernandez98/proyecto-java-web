# MariaDB Store Procedure + Java Web Standard 
<code><img src="https://th.bing.com/th/id/R.e15d011fdfddb39db6df8efb30cc9248?rik=ypC%2bv1ziRsmSNg&pid=ImgRaw&r=0" width="40" height="40" title="MariaDB"></code> 
+
<code><img src="https://cdn-icons-png.flaticon.com/512/5968/5968282.png" width="40" height="40" title="Java"></code>

## Stack usado
- JavaEE 
- Jdk 1.8
- MariaDB

## Herramientas usadas para el desarrollo
- Netbeans IDE 15
- HeidiSQL
- GlassFish

## Paso a paso para instalar y ejecutar localmente el proyecto

### Para el APP
- Descargar e instalar el jdk 1.8
- Descargar e instalar el IDE de preferencia
- Descargar e instalar GlassFish 
- Clonar el repositorio 
- Importar el repositorio al IDE

### Para la BD
- Descargar e instalar MariaBD
- Ingresar a HeidiSQL o motor de BD de su preferencia
- Para crear la BD use el SQl que esta en la raiz del proyecto
- Cambiar las credenciales de la conexión en la clase __Conexion.java__ que esta en:
```
com.arquitectura.ufps.util
```

Una vez realizados los pasos anteriormente mencionados ejecute el proyecto con GlassFish
<br>
Luego en el navegador de preferencia ingrese:
```
http://localhost:8080/NombreProyecto
```
