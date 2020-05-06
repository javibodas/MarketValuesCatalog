export default function getSearchValues(value, country, index){

    //var reqOptions = { method: 'GET',headers: new Headers(),mode: 'cors',cache: 'default' }

	return fetch(`http://localhost:8080/values/search?value=${value}&country=${country}&stock=${index}`)
      	    .then(res => res.json())

}