import React, { useState, useEffect } from 'react';
import { Card, CardContent, Typography, Grid, Button } from '@material-ui/core';
import AddIcon from '@material-ui/icons/Add';
import { Link } from 'react-router-dom';
import CardActions from '@material-ui/core/CardActions';
import axios from 'axios';
import './Messages.css';

const Message = props => {

    return (
        <Grid item component={Card} xs={12} md={3} sm={6} className="card">
            <CardContent>
                <Typography color="textSecondary">
                    {props.message.id}
                </Typography>
                <Typography variant="h5">
                    {props.message.text}
                </Typography>
            </CardContent>
            <CardActions>
                <span className="btn btn-default">
                    <Link to={`/message/${props.message.id}`}>View</Link>
                </span>
            </CardActions>
        </Grid>
    );
}

const Messages = () => {

    const [messages, setMessages] = useState([]);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        setIsLoading(true);
        axios.get('http://localhost:8080/getMessages')
             .then(response => {
                 setMessages(response.data);
                 setIsLoading(false);
                })
             .catch(error => console.log(error));
    }, [])

    const exerciseList = () => {
        return messages.map(currentMessage => {
            return <Message message={currentMessage} key={currentMessage.id} />
        })
    }

    return (
        <div className="cards">
            <br />
            <div className="container">
                {isLoading ? 
                <div>
                    <img className="loader" src={'https://media2.giphy.com/media/3oEjI6SIIHBdRxXI40/200.gif'} alt="Loading..."></img>
                </div> :
                <div>
                    <div className="add-btn">
                        <Button
                            variant="contained"
                            color="primary" 
                            startIcon={<AddIcon /> }>
                            <Link className="link-add" to='/add-message'>ADD MESSAGE</Link>
                        </Button>
                    </div>
                    <Grid container spacing={3} justify="center">
                        { exerciseList() }
                    </Grid>
                </div>
                }
            </div>
        </div>
)
}

export default Messages;