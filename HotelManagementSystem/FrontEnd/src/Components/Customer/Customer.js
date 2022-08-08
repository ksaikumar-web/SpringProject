import React, { Component } from 'react'
import axios from 'axios';
import Menu from '../Menu/menu';
import Homepage from '../HomePage/Homepage';
export default class Customer extends Component {
  constructor(props) {
    super(props);
    this.state = {
     orders : []
    };
}

componentDidMount(){
 let cid = localStorage.getItem("cid")
 console.log(cid)
 axios.get("http://localhost:8087/customerOrders/"+cid)
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
   <table border="3" align="center">
     <thead>
     <tr>
       <th>Order Id</th>
       <th>Menu Id</th>
       <th>Vendor Id</th>
       <th>Wallet Source</th>
       <th>Order Quantity</th>
       <th>Bill Amount</th>
       <th>Order Status</th>
       <th>Order Comments</th>
     </tr></thead>
     
     {
       orders.map( order =>
         <tr>
           <td>{order.ordId}</td>
           <td>{order.menuId}</td>
           <td>{order.venId}</td>
           <td>{order.walSource}</td>
           <td>{order.ordQuantity}</td>
           <td>{order.ordBillamount}</td>
           <td style={{'color': order.ordStatus === 'ACCEPTED' ? 'green' : order.ordStatus === 'DENIED' ? 'red' : 'violet'}}>{order.ordStatus}</td>
           <td>{order.ordComments}</td>
         </tr>
         )
     }
   </table></div><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
 </div>;
}
}
