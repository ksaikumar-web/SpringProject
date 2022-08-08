import React, {Component} from 'react';
import  axios  from 'axios'; 
import { withRouter } from '../../withRouter';
import Homepage from '../HomePage/Homepage';
import Registration from '../Registration/Registration';
import Navbar from '../../Navbar';
import {useNavigate} from "react-router-dom";
import './login.scss';
import LoginLogo from '../Login/Login.jpg';
import {
 BrowserRouter,Switch,Route,Routes,
  Link
} from "react-router-dom";
import { Tab } from 'bootstrap';
import { useState } from 'react';

// import { connect } from "react-redux";
// import { bindActionCreators } from "redux";
// import * as loginActions from "../../store/login/actions";
export  class login extends Component {
    
  changeEmailId(event) {  
    this.setState({  
        emailId: event.target.value
    });  
  }
  changeCustomerPassword(event) {  
    this.setState({  
        customerPassWord: event.target.value
    });  
  }

  login = () => {
    let user = this.state.emailId
    let pwd = this.state.customerPassWord
    axios.get("http://localhost:8087/custAuthenticate/"+user+"/"+pwd)
    
    .then(response => {
      if (response.data=='1') {
        localStorage.setItem("cid",user)
        axios.get("http://localhost:8087/searchById/" + user).then(response => {
              localStorage.setItem("cid", user);
        })
        this.props.navigate("/Homepage")
      }
      else{
        alert("Invalid Credentials....")
      }
      
     // alert(response.data)
     // result = response.data
      // this.setState({
      //   customers : response.data 
      // })
      console.log(response.data)
    })
    // if (this.state.userName=="Hexaware" && this.state.passWord=="Hexaware") {
    //   //alert("Correct Credentails...");
    //   this.props.navigate("/menu")
    // } else {
    //   alert("Invalid Credentials...")
    // }
    
  }
  constructor(props) {
    super(props);
    this.state = {
      emailId:'',
      customerPassWord:'',
      result : ''
    };
}
    
    render() {
      return <div className='cont_login'>
       <div className='demo'>
        <div className='login'>
        <Link to="/" className='login__signup active'>Login</Link><Link to="/Registration" className='login__signup active'>Registration</Link>
	  <div className='login_form'>
    <div className='login__row'>
          <svg className='login__icon name svg-icon' viewBox="0 0 20 20" xmlns=''>
            <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
          </svg>
              <input type="text" id="emailId"
                 value={this.state.emailId} 
                 onChange={this.changeEmailId.bind(this)} className='login__input name' placeholder='EMAIL ID'/>
              </div>
              <div className='login__row'>
          <svg className='login__icon pass svg-icon' viewBox="0 0 20 20">
  
            <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
          </svg>
                <input type="password" id="customerPassWord"
                   value={this.state.customerPassWord}
                   onChange={this.changeCustomerPassword.bind(this)} className="login__input pass" placeholder='Password'/>
              </div>
                <input type="button" value="Login" onClick={this.login} className="login__submit"/>
      
            </div>
            </div>
            </div> 
            </div>
            
    }
  }
  export default withRouter(login);