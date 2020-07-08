import axios from 'axios'

const PROJECTS_REST_API_URL = 'http://localhost:8080/getProjects';

class ProjectService {

    getProjects(){
        return axios.get(PROJECTS_REST_API_URL);
    }
    
    getProject(projectName){
        return axios.get(PROJECTS_REST_API_URL + "/" + projectName);
    }
}

export default new ProjectService();
