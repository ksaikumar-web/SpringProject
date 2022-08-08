import React, { Component } from 'react'
import axios from 'axios';
import Menu from '../Menu/menu';
export default class CustomerRooms extends Component {
    constructor(props) {
        super(props);
        this.state = {
         orders : []
        };
    }
    
    componentDidMount(){
     let cid = localStorage.getItem("cid")
     console.log(cid)
     axios.get("http://localhost:8087/searchById/"+cid)
     .then(response => {
       this.setState({
         orders : response.data
       })
       console.log(response.data)
     })
    }
    
    render() {
     const {orders} = this.state
     return <div className='cont'>
      <Menu/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
      <div className='login__signupHST'>
       <table colspan='2' border="" align="center">
         <thead>
         <tr>
           <th>Email Id</th>
           <th>Name</th>
           <th>City</th>
           <th>Mobile</th>
           <th>Dob</th>
           <th>Password</th>
         </tr></thead>
         
             <tr>
               <td>{orders.emailId}</td>
               <td>{orders.lastName+" "+orders.firstName}</td>
               <td>{orders.customerCity}</td>
               <td>{orders.customerPhone}</td>
               <td>{orders.dob}</td>
               <td>{orders.customerPassword}</td>


             </tr>
       </table></div><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
     </div>;
    }
}