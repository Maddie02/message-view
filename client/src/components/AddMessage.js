import React, { useState, useEffect } from 'react';
import { Grid, Button, Checkbox, Typography, FormControl, MenuItem, Select, InputLabel, Collapse } from '@material-ui/core';
import IconButton from '@material-ui/core/IconButton';
import CloseIcon from '@material-ui/icons/Close';
import Alert from '@material-ui/lab/Alert';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';

import axios from 'axios';

const useStyles = makeStyles((theme) => ({
  root: {
    '& .MuiTextField-root': {
      margin: theme.spacing(1),
      width: '25ch',
    },
  },
  title: {
    textAlign: 'center',
    marginBottom: '20px',
  },
  createMessage: {
    backgroundColor: '#ffffff',
    boxShadow: '0px 14px 80px rgba(34, 35, 58, 0.2)',
    padding: '40px 55px',
    margin: '100px 300px',
    borderRadius: '15px',
  },
  inputs: {
      marginBottom: '10px',
  },
  submit: {
      textAlign: 'center',
  },
  alertMessage: {
    marginBottom: '5px',
  },
}));

const AddMessage = () => {
  const classes = useStyles();

  const [forDocumentation, setForDocumentation] = useState(false);
  const [forTranslation, setForTranslation] = useState(false);
  const [version, setVersion] = useState(0);
  const [messageTypes, setMessageTypes] = useState([]);
  const [messageType, setMessageType] = useState([]);
  const [text, setText] = useState('');
  const [messageID, setMessageID] = useState('');
  const [openAlert, setOpenAlert] = useState(false);

  useEffect(() => {
    axios.get('http://localhost:8080/getComponent_ALF')
         .then(response => {
           setVersion(response.data.version);
           setMessageTypes(response.data.messageTypes);
           setMessageType(response.data.messageTypes[0]);
           console.log(response.data);
         })
         .catch(error => console.log(error));
  }, [])

  const handleDocChange = event => {
    setForDocumentation(event.target.checked);
  }

  const handleTrChange = event => {
    setForTranslation(event.target.checked);
  }

  const handleTypeChange = event => {
    setMessageType(event.target.value);
  }

  const handleTextChange = event => {
    setText(event.target.value);
  }

  const handleMessageIDChange = event => {
    setMessageID(event.target.value);
  }

  const onSubmit = event => {

    event.preventDefault();

    const data = {
      messageType,
      messageID,
      text,
      forDocumentation,
      forTranslation
    }

    console.log(data);

    // axios.post('http://localhost:8080/createMessage', data)
    //      .then(res => console.log(res.data));

    document.getElementById('outlined-basic').value ='';    
    document.getElementById('outlined-basic-text').value ='';
    setForTranslation(false);
    setForDocumentation(false);
  }

  return (
        <div className={classes.createMessage}>
          <Collapse in={openAlert}>
            <Alert
              className={classes.alertMessage}
              action={
                <IconButton
                  aria-label="close"
                  color="inherit"
                  size="small"
                  onClick={() => {
                    setOpenAlert(false);
                  }}
                >
                  <CloseIcon fontSize="inherit" />
                </IconButton>
              }
            >
              Succesfully added new message!
            </Alert>
          </Collapse>
            <form autoComplete="off" action="http://localhost:8080/createMessage" method="POST">
                <h3 className={classes.title}>Add message</h3>
                <Grid container spacing={2}>
                    <Grid item xs={6}>
                        {version ? 
                        <TextField
                          disabled
                          fullWidth
                          id="outlined-disabled"
                          label="Version"
                          defaultValue={version}
                          variant="outlined"
                          className={classes.inputs}
                        /> : <p>Loading...</p> }
                        <TextField
                          fullWidth
                          required
                          id="outlined-basic"
                          label="messageID"
                          name="messageID"
                          variant="outlined"
                          onChange={handleMessageIDChange}
                          className={classes.inputs} />
                        <Typography display="inline" name="documentation" className={classes.inputs} variant="h6" color="textPrimary">For Documentation:</Typography>
                          <Checkbox
                          	name="documentation" 
                            checked={forDocumentation}
                            onChange={handleDocChange}
                            color="primary"
                          />
                    </Grid>
                    <Grid item xs={6}>
                      { messageTypes ? 
                        <FormControl variant="outlined" fullWidth>
                          <InputLabel id="demo-simple-select-outlined-label">MessageType</InputLabel>
                          <Select
                            fullWidth
                            required
                            labelId="demo-simple-select-outlined-label"
                            id="demo-simple-select-outlined"
                            value={messageType}
                            onChange={handleTypeChange}
                            label="MessageType"
                            name="messageType"
                            className={classes.inputs}
                          >
                            {
                              messageTypes.map(type => {
                                return <MenuItem key={type} value={type}>
                                          {type}
                                      </MenuItem>
                              })
                            }
                          </Select>
                        </FormControl>
                        : <p>Loading...</p> }
                        <TextField 
                          fullWidth
                          required
                          name="text"
                          id="outlined-basic-text"
                          label="Text"
                          variant="outlined"
                          onChange={handleTextChange}
                          className={classes.inputs} />
                        <Typography display="inline" name="translation" className={classes.inputs} variant="h6" color="textPrimary">For Translation:</Typography>
                          <Checkbox
                            name="translation" 
                            checked={forTranslation}
                            onChange={handleTrChange}
                            color="primary"
                          />
                    </Grid>
                    <Grid item xs={12} className={classes.submit}>
                        <Button
                            type="submit"
                            variant="contained"
                            color="primary"
                            onClick={() => {
                              setOpenAlert(true);
                            }}
                          >
                            Submit
                        </Button>
                    </Grid>
                </Grid>
            </form>
        </div> 
  );
}

export default AddMessage;