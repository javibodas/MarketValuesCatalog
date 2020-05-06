import React from 'react'
import { Link } from 'wouter'

function Header(props){
    return(
        <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	        <Link className="navbar-brand" to="/">MarketValuesApp</Link>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    	        <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse user-login">
    	        <Link className="btn btn-outline-light" to="loginUser">Sign In</Link>
    	        <Link className="btn btn-outline-light" to="/createUser">Sign Up</Link>
            </div>
        </nav>
    )
}

export default Header