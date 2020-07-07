import React, { useState, useEffect } from 'react';

import { Link } from 'react-router-dom';
import { Card, CardHeader, CardContent, Typography, makeStyles, Grid, CardActions } from '@material-ui/core';

import KeyboardBackspaceIcon from '@material-ui/icons/KeyboardBackspace';

import axios from 'axios';

const useStyles = makeStyles(() => ({
    cardMessage: {
        padding: '50px 0',
        margin: '15px 100px',
    },
    cardHeader: {
        textAlign: 'center',
    },
    cardPadding: {
        paddingLeft: '100px',
    },
    element: {
        letterSpacing: '2px',
        lineHeight: '2.3em',
    },
    back: {
        lineHeight: '2.3em',
        marginLeft: '80%',
    }
}))

const MessageView = props => {

    const classes = useStyles();
    const [id, setId] = useState(null);
    const [consistentMessageID, setConsistentMessageID] = useState(null);
    const [consistentComponentID, setConsistentComponentID] = useState(null);
    const [consistentProjectID, setConsistentProjectID] = useState(null);
    const [messageID, setMessageID] = useState(null);
    const [text, setText] = useState('');
    const [version, setVersion] = useState('');
    const [messageType, setMessageType] = useState('');
    const [state, setState] = useState('');
    const [forDocumentation, setForDocumentation] = useState(false);
    const [forTranslation, setForTranslation] = useState(false);
    const [createdBy, setCreatedBy] = useState('');
    const [createdDate, setCreatedDate] = useState(new Date());
    const [lastModifiedBy, setLastModifiedBy] = useState('');
    const [lastModifiedDate, setLastModifiedDate] = useState(new Date());

    useEffect(() => {
        axios.get(`http://localhost:8080/messages/${props.match.params.id}`)
             .then(response => {
                 setId(response.data.id);
                 setConsistentMessageID(response.data.consistentMessageID);
                 setConsistentComponentID(response.data.consistentComponentID);
                 setConsistentProjectID(response.data.consistentProjectID);
                 setMessageID(response.data.messageID);
                 setText(response.data.text);
                 setVersion(response.data.version);
                 setMessageType(response.data.messageType);
                 setState(response.data.state);
                 setForDocumentation(response.data.forDocumentation);
                 setForTranslation(response.data.forTranslation);
                 setCreatedBy(response.data.createdBy);
                 setCreatedDate(response.data.createdDate);
                 setLastModifiedBy(response.data.lastModifiedBy);
                 setLastModifiedDate(response.data.lastModifiedDate);
                })
             .catch(error => console.log(error));
    }, [props.match.params.id]);

    return (
        <div>
            <br />
            <Card className={classes.cardMessage}>
                <CardHeader className={classes.cardHeader} title={text} subheader={id} />
                <CardContent>
                    <Grid container spacing={2} className={classes.cardPadding}>
                        <Grid item xs={6}>
                            <Typography component="div" className={classes.element}>
                                consistentMessageID:
                                <Typography variant="body1" color="textSecondary" display="inline"> {consistentMessageID}</Typography>
                            </Typography>
                            <Typography component="div" className={classes.element}>
                                consistentComponentID:
                                <Typography variant="body1" color="textSecondary" display="inline"> {consistentComponentID}</Typography>
                            </Typography>
                            <br />
                            <Typography component="div" className={classes.element}>
                                text:
                                <Typography variant="body1" color="textSecondary" display="inline"> {text}</Typography>
                            </Typography>
                            <Typography component="div" className={classes.element}>
                                state:
                                <Typography variant="body1" color="textSecondary" display="inline"> {state}</Typography>
                            </Typography>
                            <Typography component="div" className={classes.element}>
                                forDocumentation:
                                <Typography variant="body1" color="textSecondary" display="inline"> {forDocumentation.toString()}</Typography>
                            </Typography>
                            <Typography component="div" className={classes.element}>
                                createdBy:
                                <Typography variant="body1" color="textSecondary" display="inline"> {createdBy}</Typography>
                            </Typography>
                            <Typography component="div" className={classes.element}>
                                createdDate:
                                <Typography variant="body1" color="textSecondary" display="inline"> {createdDate.toString()}</Typography>
                            </Typography>
                        </Grid>
                        <Grid item xs={6}>
                            <Typography component="div" className={classes.element}>
                                consistentProjectID:
                                <Typography variant="body1" color="textSecondary" display="inline"> {consistentProjectID}</Typography>
                            </Typography>
                            <Typography component="div" className={classes.element}>
                                messageID:
                                <Typography variant="body1" color="textSecondary" display="inline"> {messageID}</Typography>
                            </Typography>
                            <br />
                            <Typography component="div" className={classes.element}>
                                version:
                                <Typography variant="body1" color="textSecondary" display="inline"> {version}</Typography>
                            </Typography>
                            <Typography component="div" className={classes.element}>
                                messageType:
                                <Typography variant="body1" color="textSecondary" display="inline"> {messageType}</Typography>
                            </Typography>
                            <Typography component="div" className={classes.element}>
                                forTranslation:
                                <Typography variant="body1" color="textSecondary" display="inline"> {forTranslation.toString()}</Typography>
                            </Typography>
                            <Typography component="div" className={classes.element}>
                                lastModifiedBy:
                                <Typography variant="body1" color="textSecondary" display="inline"> {lastModifiedBy}</Typography>
                            </Typography>
                            <Typography component="div" className={classes.element}>
                                lastModifiedDate:
                                <Typography variant="body1" color="textSecondary" display="inline"> {lastModifiedDate.toString()}</Typography>
                            </Typography>
                        </Grid>
                    </Grid>
                </CardContent>
                <CardActions>
                    <Link className={classes.back} to="/messages"><KeyboardBackspaceIcon /> Back to all messages</Link>
                </CardActions>
            </Card>
        </div>
    )
}

export default MessageView;