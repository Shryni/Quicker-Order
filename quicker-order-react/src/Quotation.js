import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import { Form } from 'semantic-ui-react';
class Quotation extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <Button color="link"><Link to="/quickerorder/getAllQuotations">Quotations</Link></Button>
            <Form >
                            <h1 className="ui centered">Quotation Details</h1>
                             <Form.Field>
                                <label>Quote ID: </label>
                                <input
                                //placeholder='Requestor Store Name'
                                //onChange={this.props.handleChange('Requestor_store_name')}
                                //defaultValue={values.firstName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Status: </label>
                                <input
                                //placeholder='Requestor Store Name'
                                //onChange={this.props.handleChange('Requestor_store_name')}
                                //defaultValue={values.firstName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Date: </label>
                                <input
                                //placeholder='Requestor Store Address Line1:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line1')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Quote Validity: </label>
                                <input
                                //placeholder='Requestor Store Address Line2:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line2')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Transport: </label>
                                <input
                                //placeholder='Requestor Store Address Line3:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line3')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Price: </label>
                                <input
                                //placeholder='Requestor Store Address Line3:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line3')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>

                            <Form.Field>
                                <label>Quote From: </label>
                                <input
                                //placeholder='Requestor Store Address Line3:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line3')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Button onClick={this.saveAndContinue}>Save And Continue </Button>
                        </Form>
        </Container>
      </div>
    );
  }
}

export default Quotation;