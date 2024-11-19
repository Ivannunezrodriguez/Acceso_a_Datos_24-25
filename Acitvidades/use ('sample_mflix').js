/*
use ('sample_mflix')
//busca entre valores grate than less than un array de datos 
//db.movies.find({year:{$gt:1900,$lt:1991}},{title:1,year:2})
//busca todos
//db.movies.find
//busca el primero
//db.movies.findOne
//descendente
//db.movies.find({year:1990},{title:1,year:2}).sort({title:1})
//ascendente
//db.movies.find({year:1990},{title:1,year:2}).sort({title:-1})
//insertar
//db.movies.insert({title:"acceso a datos ",year:2025})
//buscamos el insert
//db.movies.find({year:2025})
//modficar un valor 
//db.movies.updateOne(    { year: { $eq: 2025 } },    { $set: { title: "borja" } });
// se añade un array nuevo 
//db.movies.updateOne({year:{$eq:2025}},{$push:{profesor:"borja"}})
//eliminar 
//db.movies.deleteOne({year:{$eq:2025}})
//db.movies.find({year:2025})

/!*READ
5. Obtener todos los alumnos que están matriculados en DAM
db.alumnos.find({higher_grade:{$eq:"DAM"}},{name:1})
6. Obtener todos los alumnos que tienen más de 20 años
db.alumnos.find({age:{$gt:20}},{name:1})
7. Obtener todos los profesores que imparten la asignatura de Programación
db.profesores.find({"subjects":{$eq:"Programacion multimedia"}},{name:1})
8. Obtener todos los profesores que son ingenieros informáticos
db.profesores.find({"title":{$eq: "Ingeniero informatico"}},{name:1})
9. Obtener todos los profesores que tienen mensos de 40 años y más de 30
db.profesores.find({age:{$gt:30,$lt:40}},{name:1})
10. Obtener el profesor mejor valorado*!/
db.profesores.findOne({} ,{name:1,rating:2}).sort({rating:-1}).limit(1)
//11. Obtener el profesor que más asignaturas imparte
db.profesores.find({},{name:1}).sort({subjects:-1}).limit(1)


/!*
UPDATE
12. Actualizar la edad del alumno cuyo correo es aprilmanning@proflex.com a
32
db.alumnos.updateMany({"email":{$eq:"aprilmanning@proflex.com"}},{$set:{year:32}})
13. Actualizar la edad de todos los alumnos del ciclo de DAM en un año
db.alumnos.updateMany({"higher_grade":{$eq:"DAM"}},{$inc:{"age":1}})
14. Actualizar todos los alumnos y añade el campo FCTs puesto como true
db.alumnos.
db.alumnos.find({"FCT":{$eq:true}},{name:1})

15. Actualiza todos los alumnos documentos que tengan una nota inferior a 5 y
pon las FCTs como false
db.alumnos.updateMany({"calificaation":{$lt:5}},{$set:{FCT:false}})
DELETE
16. Elimina todos aquellos registros de los alumnos que tenga las FCTs como
false
db.alumnos.deleteMany({"FCT":false})
17. Elimina todos aquellos profesores que tienen una calificación entre 1 y 4
db.profesores.deleteMany({"rating":{$lt:4,$gt:1}})
*!/
*!/
*/
