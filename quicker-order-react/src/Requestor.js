import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import { Form } from 'semantic-ui-react';
class Requestor extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <Button color="link"><Link to="/quickerorder/getAllRequestor">Requestor</Link></Button>
            <Form >
                            <h1 className="ui centered">Enter Requestor Details</h1>
                             <Form.Field>
                                <label>Requestor ID: </label>
                                <input
                                //placeholder='Requestor Store Name'
                                //onChange={this.props.handleChange('Requestor_store_name')}
                                //defaultValue={values.firstName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>First Name: </label>
                                <input
                                //placeholder='Requestor Store Name'
                                //onChange={this.props.handleChange('Requestor_store_name')}
                                //defaultValue={values.firstName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Last Name: </label>
                                <input
                                //placeholder='Requestor Store Address Line1:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line1')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Role: </label>
                                <input
                                //placeholder='Requestor Store Address Line2:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line2')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Role ID: </label>
                                <input
                                //placeholder='Requestor Store Address Line3:'
                                //onChange={this.props.handleChange('Requestor_storeAddress_line3')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Requestor Store: </label>
                                <input
                                //placeholder='City:'
                                //onChange={this.props.handleChange('Requestor_store_city')}
                                //defaultValue={values.lastName}
                                />
                            </Form.Field>
                            <Form.Field>
                                <label>Requestor Store: </label>
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

export default Requestor;