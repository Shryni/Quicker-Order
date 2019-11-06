import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import VendorStore from './VendorStore';
import RequestorStore from './RequestorStore';

import Quotation from './Quotation';
import PurchaseRequisition from './PurchaseRequisition';

import Requestor from './Requestor';
import PurchaseOrder from './PurchaseOrder';

import Item from './Item';
import Invoice from './Invoice';

import MainForm from './MainForm';
import { Container } from 'semantic-ui-react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

//import GroupList from './GroupList';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/vendorstore' exact={true} component={VendorStore}/>
          <Route path='/requestorstore' exact={true} component={RequestorStore}/>
          <Route path='/quotation' exact={true} component={Quotation}/>
          <Route path='/requestor' exact={true} component={Requestor}/>
          <Route path='/item' exact={true} component={Item}/>
         <Route path='/invoice' exact={true} component={Invoice}/>
          <Route path='/purchaserequisition' exact={true} component={PurchaseRequisition}/>
          <Route path='/purchaseorder' exact={true} component={PurchaseOrder}/>
             <Container textAlign='center'>
                 <MainForm />
              </Container>
        </Switch>
      </Router>
    )
  }
}

export default App;