import React from 'react';
import { Grid, Button } from '@material-ui/core';
import TextField from '@material-ui/core/TextField';
import { makeStyles } from '@material-ui/core/styles';

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
  }
}));

const AddMessage = () => {
  const classes = useStyles();

  return (
        <div className={classes.createMessage}>
            <form autoComplete="off">
                <h3 className={classes.title}>Add message</h3>
                <Grid container spacing={2}>
                    <Grid item xs={6}>
                        <TextField fullWidth id="outlined-basic" label="messageID" variant="outlined" className={classes.inputs} />
                        <TextField fullWidth id="outlined-basic" label="forDocumentation" variant="outlined" className={classes.inputs} />                        
                    </Grid>
                    <Grid item xs={6}>
                        <TextField fullWidth id="outlined-basic" label="Text" variant="outlined"className={classes.inputs} />
                        <TextField fullWidth id="outlined-basic" label="forTranslation" variant="outlined" className={classes.inputs} />
                    </Grid>
                    <Grid item xs={12} className={classes.submit}>
                        <Button
                            variant="contained"
                            color="primary">
                            Submit
                        </Button>
                    </Grid>
                </Grid>
            </form>
        </div> 
  );
}

export default AddMessage;