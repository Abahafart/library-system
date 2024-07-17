const fs = require('fs');
const axios = require('axios');
const path = '../json/authors.json';

// Leer el archivo JSON
fs.readFile(path, 'utf8', (err, data) => {
  if (err) {
    console.error('Error al leer el archivo JSON:', err);
    return;
  }

  // Parsear el JSON
  const authors = JSON.parse(data);

  // Iterar sobre cada autor y enviar la petición
  authors.forEach(author => {
    sendAuthorData(author);
  });
});

// Función para enviar los datos de un autor a la petición REST
const sendAuthorData = (author) => {
  axios.post('http://localhost:10001/authors', author)
  .then(response => {
    console.log('Datos enviados correctamente:', response.data);
  })
  .catch(error => {
    console.error('Error al enviar los datos:', error);
  });
};
