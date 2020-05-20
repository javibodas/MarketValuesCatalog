import React, { useContext, useState } from 'react'
import { Redirect } from 'wouter';
import UserContext from '../../../context/userContext';
import deleteUser from '../../../services/users/deleteUser';

export default function SettingsUser(props){

    const { user, setUser } = useContext(UserContext);
    const [ redirect , setRedirect ] = useState(false);


    const handleClickDeleteAccount = function(event){
        event.preventDefault()
        
        if (confirm("¿Do you want to delete the account?")) {
            
            deleteUser(user.userData.objid,user.token)
            .then((result) => {
            result.result ? setRedirect(true) : alert(result.message)
            })
            .catch((error) => console.log(error))
        
        } 
    }

    const handleModifyDataUser = function(event){
        event.preventDefault()
    }

    if(redirect)
        return (<Redirect to="/"/>);
    else
        return(
        <div className="container">
            <form onSubmit={handleModifyDataUser}>
                <div class="form-group row">
                    <label for="staticEmail" class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-10">
                        <input type="text" readonly className="form-control" id="staticEmail" value={user.userData.name} />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="staticEmail" class="col-sm-2 col-form-label">Last Name</label>
                    <div class="col-sm-10">
                        <input type="text" readonly className="form-control" id="staticEmail" value={user.userData.lastName} />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="text" className="form-control" id="staticEmail" value={user.userData.email} />
                    </div>
                </div>
                <div class="form-group row">
                    <div className="col">
                        <button type="submit" className="btn btn-secondary">Modify</button>
                    </div>
                    <div className="col">
                        <button className="btn btn-danger" onClick={handleClickDeleteAccount}>Delete Account</button>
                    </div>
                </div>
            </form>
        </div>
    );
}