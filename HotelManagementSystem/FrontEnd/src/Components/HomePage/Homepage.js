import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import Menu from '../Menu/menu';
import Login from '../Login/Login'
export default class Homepage extends Component {
    constructor(props) {
        super(props);
        let cid = localStorage.getItem("cid");
        this.state = {
         customerId:cid,
         menuId:'',
         vendorId:'',
         walSource:'',
         qty:'',
         comments:'',
         wallets:[]
        };
    }
  render() {
    return (
        
      <div className='cont'>
      <Menu/>
      
      <div className='parent'><div className='child'><Link to="/Orderfood" className="login__signup active">ORDER FOOD</Link></div>
      </div><div className='parent'><div className="child"><Link to="/Roombooking" className='login__signup active'>ROOM BOOKING</Link></div></div><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></div>
    )
  }
}
