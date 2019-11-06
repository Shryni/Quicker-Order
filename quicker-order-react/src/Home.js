import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
            <Button color="link"><Link to="/quickerorder/getAllRequestorStores">Requestor Store Details</Link></Button><br/>
            <Button color="link"><Link to="/quickerorder/getAllVendorStores">Vendor Store Details</Link></Button><br/>
            <Button color="link"><Link to="/quickerorder/getAllQuotations">Quotation Details</Link></Button><br/>
            <Button color="link"><Link to="/quickerorder/getAllInvoices">Invoice Details</Link></Button><br/>
            <Button color="link"><Link to="/quickerorder/getAllPurchaseOrders">Purchase Order Details</Link></Button><br/>
            <Button color="link"><Link to="/quickerorder/getAllPurchaseRequisitions">Purchase Requisition Details</Link></Button><br/>
            <Button color="link"><Link to="/quickerorder/getAllRequestors">Requestor Details</Link></Button><br/>
            <Button color="link"><Link to="/quickerorder/getAllItems">Item Details</Link></Button>
        </Container>
      </div>
    );
  }
}

export default Home;