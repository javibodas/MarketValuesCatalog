export default async function getSearchValues(value, country, stock){

    var reqOptions = { method: 'GET',headers: new Headers(),mode: 'cors',cache: 'default' }

	return fetch('http://localhost:8080/values/search?value='+value+'&country=&stock=')
      	    .then(res => res.json())

}