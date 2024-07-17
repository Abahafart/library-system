const fs = require('fs');
const path = 'json/authors.json';
const outputPath = 'http/requests-authors.http';

// Leer el archivo JSON
fs.readFile(path, 'utf8', (err, data) => {
  if (err) {
    console.error('Error al leer el archivo JSON:', err);
    return;
  }

  // Parsear el JSON
  const authors = JSON.parse(data);

  // Generar las peticiones HTTP
  let httpRequests = authors.map(author => {
    return `###\nPOST http://localhost:10001/authors\nContent-Type: application/json\n\n${JSON.stringify(author, null, 2)}`;
  }).join('\n\n');

  // Escribir las peticiones en el archivo .http
  fs.writeFile(outputPath, httpRequests, (err) => {
    if (err) {
      console.error('Error al escribir el archivo .http:', err);
    } else {
      console.log('Archivo .http generado correctamente.');
    }
  });
});
