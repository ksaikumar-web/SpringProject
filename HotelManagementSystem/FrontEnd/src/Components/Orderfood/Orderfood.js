import React, { Component } from 'react'
import axios from 'axios';
import moment from 'moment'
import { withRouter } from '../../withRouter';
import Menu from '../Menu/menu';
import { useNavigate } from 'react-router-dom';
import {Link} from 'react-router-dom';
export  class Orderfood extends Component {
    constructor(props) {
        super(props);
        const m=moment();
        const mydate=m.format("YYYY-MM-DD");
        console.log(mydate);
        let cid = localStorage.getItem("cid");
        const maxNumber=200;
        const randomNumber = Math.floor((Math.random() * maxNumber) + 1);
        this.state = {
         customerId:cid,
         ordId:randomNumber,
         menuId:'',
         vendorId:'',
         walSource:'',
         qty:'',
         ordDate:mydate,
         comments:'',
         wallets:[],
         menu:[]
        };
    }
    changeCustomerId(event) {  
     this.setState({  
         customerId : event.target.value
     });
   }
   changeOrdId(event){
    this.setOrdId({
      ordId : event.target.value
    })
   } 
   changeOrdDate(event) {  
    this.setState({  
        ordDate : event.target.value
    });
  }  

     changeVendorId(event) {  
       this.setState({  
           vendorId : event.target.value
       });  
     }

     changeMenuId(event) {  
       this.setState({  
           menuId : event.target.value
       });  
     }

     changeWalSource(event){  
       this.setState({  
           walSource : event.target.value
       });  
     }

     changeQty(event){  
       this.setState({  
           qty : event.target.value
       });  
     }

     changeComments(event){  
       this.setState({  
           comments : event.target.value
       });  
     }

     placeOrd = () => {
      console.log(this.state.ordId);
      console.log(this.state.ordDate);
       axios.post('http://localhost:8087/placeOrder',
     {ordId:this.state.ordId, 
      emailId: this.state.customerId,
      venId: this.state.vendorId, 
       menuId: this.state.menuId,
       walSource: this.state.walSource,
       ordDate:this.state.ordDate, 
       ordQuantity: this.state.qty,
       ordComments: this.state.comments },)
     .then(res => {
       console.log(res);
       console.log(res.data);
       this.state.result = res.data
       alert(res.data)
       this.props.navigate("/HomePage")
     })
     }

    componentDidMount(){
       axios.get('http://localhost:8087/getallwalletsource/'+this.state.customerId)
       .then(response=>{
         this.setState({
           wallets: response.data
         })
       })
       axios.get("http://localhost:8087/showMenu")
      .then(response => {
        this.setState({
          menu : response.data 
        })
        console.log(response.data)
      })
     }
     

   render() {
    
    const {wallets} = this.state;
    const{menu}=this.state;
    let walletList = wallets.length > 0
        && wallets.map((item) => {
          return (
              <option value={item}>{item}</option>
          )
      }, this);
     return<div>
     <div className='cont_order left'><div className="login__signupHS">
     <div className='menu-wrap'>
     <p className='h1'>MENU</p>
      <table border='2' align='center'>
       <thead>
   <tr>
     <th>Menu Id</th>
     <th>Name</th>
     <th>Price</th>
     <th>Speciality</th>
   </tr></thead>
   
   {
     menu.map( m => 
       <tr>
         <td>{m.menuId}</td>
         <td>{m.menuName}</td>
         <td>{m.menuPrice}</td>
         <td width={30}>{m.menuSpeciality}</td>
       </tr>
   )
   }
 </table>
 </div>
 </div></div>
 <div className='cont_order right'>
 <div className="food-wrap">
        <div class="login-html">
        
       <table align="center">
       
        <thead><th colSpan="2">Place Order</th></thead>
       <br/>
       <tr>
         <td><input hidden type="text" id="ordId" value={this.state.ordId} onChange={this.changeOrdId.bind(this)}></input></td>
       </tr>
       <tr>
         <td><input hidden type="text" id="customerId" value={this.state.customerId} onChange={this.changeCustomerId.bind(this)}></input></td>
       </tr><br/>
       <tr>
         <th>Menu Id</th>
        <td><input type="text" id = "menuId" value={this.state.menuId} onChange={this.changeMenuId.bind(this)}></input></td>
       </tr><br/>
       <tr>
         <td><input hidden type="text" id = "vendorId" value="1" onChange={this.changeVendorId.bind(this)}></input></td>
       </tr>
       <tr>
          <td><input hidden type="date" id = "ordDate" value={this.state.ordDate} onChange={this.changeOrdDate.bind(this)}></input></td>
        </tr>
       <tr>
         <th>Select Wallet</th>
         <td><select onChange = {this.changeWalSource.bind(this)}>
             {walletList}
           </select></td>
         {/* <td><input type="text" id="walSource" value={this.state.walSource} onChange={this.changeWalSource.bind(this)}></input></td> */}
       </tr><br/>
       <tr>
         <th>Order Quantity</th>
         <td><input type="text" id="qty" value={this.state.qty} onChange={this.changeQty.bind(this)}></input></td>
       </tr><br/>
       <tr>
         <th>Order Comments</th>
         <td><input type="text" id="comments" value={this.state.comments} onChange={this.changeComments.bind(this)}></input></td>
       </tr><br/>
       <tr>
         <th></th><td><input type="button" value="PlaceOrder" onClick={this.placeOrd} id="btn"></input></td>
       </tr>
       </table>
       </div></div></div>
       <Menu/>
   </div>;
     
  }
}
export default withRouter(Orderfood);
