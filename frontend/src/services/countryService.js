import axios from "../custom-axios/axios";

const countryService = {
    getCountries: () => {
        return axios.get("/countries");
    },
    getCountryById: (id) => {
        return axios.get("/countries/" + id);
    },
    addCountry: (name, continent) => {
        return axios.post("/countries", {
            "name": name,
            "continent": continent
        })
    },
    editCountry: (id, name, continent) => {
        return axios.put("/countries/" + id, {
            "name": name,
            "continent": continent
        })
    },
    deleteCountry: (id) => {
        return axios.delete("/countries/" + id);
    }
}

export default countryService;