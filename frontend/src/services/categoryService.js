import axios from "../custom-axios/axios";

const categoryService = {
    getCategories: () => {
        return axios.get("/books/categories");
    }
}

export default categoryService;