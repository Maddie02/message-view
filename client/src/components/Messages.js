import React, { useState, useEffect } from 'react';
import { Card, CardContent, Typography, Grid, Button } from '@material-ui/core';
import { Pagination } from '@material-ui/lab';
import AddIcon from '@material-ui/icons/Add';
import { Link } from 'react-router-dom';
import CardActions from '@material-ui/core/CardActions';
import DeleteIcon from '@material-ui/icons/Delete';
import VisibilityIcon from '@material-ui/icons/Visibility';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import axios from 'axios';
import './Messages.css';

const Message = props => {

    const [openDialog, setOpenDialog] = useState(false);

    const handleClickOpen = () => {
        setOpenDialog(true);
    }

    const handleClose = () => {
        setOpenDialog(false);
    }

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
                <Button
                    variant="outlined"
                    color="primary"
                    startIcon={<VisibilityIcon />}>
                    <Link className="view" to={`/message/${props.message.id}`}>VIEW</Link>
                </Button>
                <Button
                    variant="outlined"
                    color="default"
                    startIcon={<DeleteIcon />}
                    onClick={handleClickOpen}>
                        DELETE
                </Button>
                <Dialog
                    open={openDialog}
                    onClose={handleClose}
                    aria-labelledby="alert-dialog-title"
                    aria-describedby="alert-dialog-description"
                >
                    <DialogTitle id="alert-dialog-title">{"Are you sure you want to delete that message?"}</DialogTitle>
                    <DialogContent>
                        <DialogContentText id="alert-dialog-description">
                            This action will permanently delete the message with id of {props.message.id}.
                        </DialogContentText>
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={handleClose} color="primary">
                            Close
                        </Button>
                        <Button onClick={() => { props.deleteMessage(props.message.id)}} color="primary">
                            Delete
                        </Button>
                    </DialogActions>
                </Dialog>
            </CardActions>
        </Grid>
    );
}

const Messages = () => {

    const [messages, setMessages] = useState([]);
    const [isLoading, setIsLoading] = useState(true);
    const [currentPage, setCurrentPage] = useState(1);
    
    useEffect(() => {
        setIsLoading(true);
        axios.get(`http://localhost:8080/getMessages/${currentPage}`)
             .then(response => {
                 setMessages(response.data);
                 setIsLoading(false);
                })
             .catch(error => console.log(error));
    }, [currentPage])

    const exerciseList = () => {
        return messages.map(currentMessage => {
            return <Message message={currentMessage} deleteMessage={deleteMessage} key={currentMessage.id} />
        })
    }

    const deleteMessage = id => {
        axios.delete(`http://localhost:8080/deleteMessage/${id}`)
             .then(response => console.log(response.data))
             .catch(error => console.log(error));
            
        setMessages(messages.filter(element => element.id !== id));
    }

    const handlePageChange = (event, value) => {
        setCurrentPage(value);
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
                    <div className="pagination-bar">
                        <Pagination 
                            page={currentPage}
                            count={195}
                            onChange={handlePageChange}
                            color="primary"
                        />
                    </div>
                </div>
                }
            </div>
        </div>
)
}

export default Messages;