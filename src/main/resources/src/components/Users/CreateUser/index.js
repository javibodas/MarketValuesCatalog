import React, { useState , useEffect, useContext } from 'react';
import { Link, Redirect } from 'wouter';
import createUser from '../../../services/users/createUser';
import './index.css';

export default function CreateUser(props){

    const [ formValues , setFormValues ] = useState({ name: '', 
                                                        lastName: '',
                                                        email: '',
                                                        username: '',
                                                        password: '' });
    const [ name, setName ] = useState('');
    const [ redirect , setRedirect ] = useState(false);

    const handleCreateUser = function(event){
        event.preventDefault();
        console.log(formValues)

        createUser(formValues)
        .then((result) => { result.result ? setRedirect(true) : alert(result.message) })
        .catch((error) => console.log(error))
    }

    if(redirect)
        return (<Redirect to="/"/>)
    else
        return (<div className="container">
                <form onSubmit={handleCreateUser} className="create-user-form">
                    <div className="row">
                        <div className="col">
                            <input onChange={e => setFormValues({...formValues, name: e.target.value})} className="form-control" type="text" placeholder="First name" value={formValues.name}/>
                        </div>
                        <div className="col">
                            <input  onChange={e => setFormValues({...formValues,lastName: e.target.value})} type="text" className="form-control" placeholder="Last name" value={formValues.lastName}/>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col">
                            <input onChange={e => setFormValues({...formValues,email: e.target.value})} type="text" className="form-control" name="email" placeholder="Email" value={formValues.email}/>
                        </div>
                        <div className="col">
                            <input onChange={e => setFormValues({...formValues,username: e.target.value})} type="text" className="form-control" name="username" placeholder="Username" value={formValues.username}/>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col">
                            <input onChange={e => setFormValues({...formValues,password: e.target.value})} type="password" className="form-control" name="password" placeholder="Password" value={formValues.password} />
                        </div>
                        <div className="col">
                            <input type="password" className="form-control" placeholder="Repeat Password" />
                        </div>
                    </div>
                    <div className="row">
                        <div className="col">
                            <button type="submit" className="form-control">Create</button>
                        </div>
                        <div className="col">
                            <Link to="/"><button className="form-control">Cancel</button></Link>
                        </div>
                    </div>
                </form>
            </div>);
}