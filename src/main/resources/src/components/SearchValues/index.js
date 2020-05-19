import React, { useState, useEffect } from 'react'
import getSearchValues from '../../services/values/getSearchValues';
import getIndexStocks from '../../services/index/getIndexStocks';
import getIndexByCountry from '../../services/index/getIndexByCountry';
import getCountries from '../../services/countries/getCountries';

import './index.css';

export default function Search(props){

	const [ values, setValues ] = useState([]);
	const [ index, setIndex ] = useState([]);
	const [ countries, setCountries ] = useState([]);
	const [ formFilter, setFormFilters ] = useState({
													value: '',
													index: '',
													country: ''
													});

	useEffect(function(){
		/*getIndexStocks()
		.then((result) => { setIndex(result); })
		.catch((error) => { console.log('ERROR:' + error)})*/


		getCountries()
		.then((result) => { setCountries(result); })
		.catch((error) => { console.log('ERROR:' + error)})

	},[]);

	function getValues(e){
		e.preventDefault();
		
		getSearchValues((formFilter.value ? formFilter.value : ''), (formFilter.contry ? formFilter.contry : ''), (formFilter.index ? formFilter.index : ''))
		  .then((result) => { setValues(result) })
		  .catch((error) => { console.log('ERROR:' + error)})
	}

	function getIndex(country){
		const el = document.querySelector('.index-selector');
		if(country == 'Choose your country'){
			el.setAttribute("disabled","")
			el.setAttribute("id","disabledSelect")
			return;
		}

		getIndexByCountry(country.toLowerCase())
		  .then((result) => { setIndex(result); el.removeAttribute("disabled"); el.removeAttribute("id")})
		  .catch((error) => { console.log('ERROR:' + error)})
	}

    return (
        <div className="container">
			<section id="section-search" className="jumbotron">
				<form onSubmit={getValues}>
					<div className="form-row">
						<div className="form-group col-md">
							<label>Country</label>
		  					<select className="form-control form-control-md country-selector" onChange={e => getIndex(e.target.options[e.target.selectedIndex].text) }>
			  					<option selected>Choose your country</option>
			  					{countries.map((country) => 
									<option id={country.id}>{country.country.toUpperCase()}</option>
								)}
							</select>
						</div>
						<div className="form-group col-md">
							<label>Index</label>
							<select id="disabledSelect" className="form-control form-control-md index-selector" searchable="Search here.." onChange={e => setFormFilters({index : e.target.options[e.target.selectedIndex].attributes[0].value})} disabled>
								<option selected>Choose an Index</option>
								{index.map((ind) => 
									<option id={ind.id}>{ind.name.toUpperCase()}</option>
								)}
							</select>
						</div>
						<div className="form-group col-md">
							<label>Value</label>
		  					<input className="form-control form-control-md mr-3 w-75" type="text" placeholder="TEF,MCD,AAPL" aria-label="Search" value={formFilter.value} onChange={e => setFormFilters({value : e.target.value})}/>
		  					<i className="fas fa-search" aria-hidden="true"></i>
		  				</div>
					</div>
					<div className="form-row search-button">
		  				<div className="form-group">
	  						<button className="btn btn-outline-dark float-right">Search</button>
	  					</div>
	  				</div>
				</form>
			</section>
			<section id="section-list-values">
				<table border="2" className="table table-dark table-hover">
					<tr>
						<th><b>Name</b></th>
						<th><b>Price</b></th>
						<th><b>Day Change</b></th>
						<th><b>PE</b></th>
						<th><b>Shares</b></th>
						<th><b>Market Cap</b></th>
						<th><b>Country</b></th>
					</tr>
					{values.map((value) =>  
						<tr>
							<td>{value.name}</td>
							<td>{value.price}</td>
							<td>{value.day_performance > '0%' ? <span className="badge badge-success">{value.day_performance} </span> : <span className="badge badge-danger">{value.day_performance} </span>}</td>
							<td>{value.pe == '' ? 'N/A' : value.pe}</td>
							<td>{value.shares}</td>
							<td>{value.market_cap}</td>
							<td>{value.country}</td>
						</tr>
					)}
				</table>
			</section>
		</div>
    )
}