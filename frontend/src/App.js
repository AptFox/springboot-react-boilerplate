import React from 'react';
import logo from './logo.svg';
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/FormControl';
import './App.css';

class App extends React.Component {

  state = { 
    username: '',
    user: ''
  }

  handleSubmit = async (event) => {
    event.preventDefault();
    //TODO: call out to api and set response in state
    fetch('http://localhost:8080/api/users/'+`${this.state.username}`)
      .then(response => response.json())
      .then( data => 
        {
          //console.log(data)
          this.setState({ 
            user: {
                    id: data.id,
                    username: data.username
                  }
          })
        })
      .catch( error => {
        console.log(error);
      })
  }

  render(){
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            React boilerplate
          </p>
          <p>
            Enter a username below
          </p>
          <Form onSubmit={this.handleSubmit}>
            <FormControl
              type="text" 
              placeholder="username"
              value={this.state.username}
              onChange={event => this.setState({username: event.target.value})}
              required
              aria-label="Name"
              aria-describedby="basic-addon2"/>  
          </Form>
          <p>
            user id: {this.state.user.id}
          <br/>
            username: {this.state.user.username}
          </p>
        </header>


      </div>
    );
  }

}

//Access ui at : http://localhost:3000/

export default App;
