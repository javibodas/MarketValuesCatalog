import React, { useState, useEffect } from 'react'
import getSearchValues from '../../services/getSearchValues';
import getIndexStocks from '../../services/getIndexStocks.js';

function Search(props){

	const [ values, setValues ] = useState([]);
	const [ index, setIndex ] = useState([]);
	const [ formFilter, setFormFilters ] = useState({
													value: '',
													index: '',
													country: ''
													});

	useEffect(function(){
		getIndexStocks()
		.then((result) => { setIndex(result); })
		.catch((error) => { console.log('ERROR:' + error)})

	},[]);

	useEffect(function(){


	},[values]);

	function getValues(e){
		e.preventDefault();
		console.log(formFilter.value + formFilter.contry + formFilter.index)
		getSearchValues((formFilter.value ? formFilter.value : ''), (formFilter.contry ? formFilter.contry : ''), (formFilter.index ? formFilter.index : ''))
		  .then((result) => { setValues(result) })
		  .catch((error) => { console.log('ERROR:' + error)})
	}

    return (
        <div className="container">
			<section id="section-search" className="jumbotron">
				<form onSubmit={getValues}>
					<div className="form-row">
						<div className="form-group col-md">
							<label>Country</label>
		  					<select className="mdb-select md-form" multiple>
			  					<option selected>Choose your country</option>
			  					<option>Brazil</option>
			  					<option>Canada</option>
			  					<option>China</option>
			  					<option>Denmark</option>
			  					<option>Dubai</option>
			  					<option>Finland</option>
			  					<option>France</option>
			  					<option>Germany</option>
			  					<option>Hong-Kong</option>
			  					<option>India</option>
			  					<option>Indonesia</option>
			  					<option>Ireland</option>
			  					<option>Malaysia</option>
			  					<option>Mexico</option>
			  					<option>Netherlands</option>
			  					<option>Pakistan</option>
			  					<option>Philippines</option>
			  					<option>Russia</option>
			  					<option>Saudi-Arabia</option>
			  					<option>Singapore</option>
			  					<option>South-Africa</option>
			  					<option>South-Korea</option>
			  					<option>Spain</option>
			  					<option>Sweden</option>
			  					<option>Switzerland</option>
			  					<option>Thailand</option>
			  					<option>Turkey</option>
			  					<option>United-Kingdom</option>
			  					<option>United-States</option>
			  					<option>Netherlands</option>
							</select>
						</div>
						<div className="form-group col-md">
							<label>Index</label>
							<select className="mdb-select md-form" searchable="Search here.." onChange={e => setFormFilters({index : e.target.options[e.target.selectedIndex].attributes[0].value})}>
								<option>Choose an Index</option>
								{index.map((ind) => 
									<option id={ind.id}>{ind.name}</option>
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
		  				<div className="form-group float-right">
	  						<button className="btn btn-outline-dark">Search</button>
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
							<td>{value.pe == '' ? N/A : value.pe}</td>
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

export default Search;