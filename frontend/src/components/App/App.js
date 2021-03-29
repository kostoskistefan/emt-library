import './App.css';
import React from "react";
import {BrowserRouter as Router, Redirect, Route, Switch} from 'react-router-dom'
import Header from "../header/header";
import Books from "../books/books";
import BookAdd from "../books/bookAdd";
import BookEdit from "../books/bookEdit";
import BookService from "../../services/bookService";
import AuthorService from "../../services/authorService";
import CountryService from "../../services/countryService";
import CategoryService from "../../services/categoryService";
import Authors from "../authors/authors";
import AuthorAdd from "../authors/authorAdd";
import AuthorEdit from "../authors/authorEdit";
import Categories from "../categories/categories";
import Countries from "../countries/countries";
import CountryAdd from "../countries/countryAdd";
import CountryEdit from "../countries/countryEdit";

export default class App extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            books: [],
            authors: [],
            countries: [],
            categories: [],
            selectedBook: {},
            selectedAuthor: {},
            selectedCountry: {}
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <Switch>
                        <Route path={["/", "/books"]} exact>
                            <Books books={this.state.books}
                                   onDelete={this.deleteBook}
                                   onEdit={this.getBookById}
                                   onTaken={this.takeBook}/>
                        </Route>
                        <Route path={"/books/add"} exact>
                            <BookAdd books={this.state.books}
                                     authors={this.state.authors}
                                     categories={this.state.categories}
                                     onAddBook={this.addBook}/>
                        </Route>
                        <Route path={"/books/edit/:id"} exact>
                            <BookEdit book={this.state.selectedBook}
                                      authors={this.state.authors}
                                      categories={this.state.categories}
                                      onEditBook={this.editBook}/>
                        </Route>

                        <Route path={"/authors"} exact>
                            <Authors authors={this.state.authors}
                                     onDelete={this.deleteAuthor}
                                     onEdit={this.getAuthorById}/>
                        </Route>
                        <Route path={"/authors/add"} exact>
                            <AuthorAdd authors={this.state.authors}
                                       countries={this.state.countries}
                                       onAddAuthor={this.addAuthor}/>
                        </Route>
                        <Route path={"/authors/edit/:id"} exact>
                            <AuthorEdit author={this.state.selectedAuthor}
                                        countries={this.state.countries}
                                        onEditAuthor={this.editAuthor}/>
                        </Route>

                        <Route path={"/countries"} exact>
                            <Countries countries={this.state.countries}
                                     onDelete={this.deleteCountry}
                                     onEdit={this.getCountryById}/>
                        </Route>
                        <Route path={"/countries/add"} exact>
                            <CountryAdd countries={this.state.countries} onAddCountry={this.addCountry}/>
                        </Route>
                        <Route path={"/countries/edit/:id"} exact>
                            <CountryEdit country={this.state.selectedCountry} onEditCountry={this.editCountry}/>
                        </Route>

                        <Route path={"/categories"} exact>
                            <Categories categories={this.state.categories}/>
                        </Route>

                        <Redirect to={"/"}/>
                    </Switch>
                </main>
            </Router>
        )
    }

    componentDidMount() {
        document.title = "EMT Library";
        this.getBooks();
        this.getAuthors();
        this.getCountries();
        this.getCategories();
    }

    // region Book Service
    getBooks = () => {
        BookService.getBooks().then(res => this.setState({books: res.data}));
    }

    getBookById = (id) => {
        BookService.getBookById(id).then(res => this.setState({selectedBook: res.data}));
    }

    takeBook = (id) => {
        BookService.takeBook(id).then(this.getBooks);
    }

    addBook = (name, category, authorId, availableCopies) => {
        BookService.addBook(name, category, authorId, availableCopies).then(this.getBooks);
    }

    editBook = (id, name, category, authorId, availableCopies) => {
        console.log(name, category, authorId, availableCopies)
        BookService.editBook(id, name, category, authorId, availableCopies).then(this.getBooks);
    }

    deleteBook = (id) => {
        BookService.deleteBook(id).then(this.getBooks);
    }
    // endregion Book Service

    // region Author Service
    getAuthors = () => {
        AuthorService.getAuthors().then(res => this.setState({authors: res.data}));
    }

    getAuthorById = (id) => {
        AuthorService.getAuthorById(id).then(res => this.setState({selectedAuthor: res.data}));
    }

    addAuthor = (name, surname, countryId) => {
        AuthorService.addAuthor(name, surname, countryId).then(this.getAuthors);
    }

    editAuthor = (id, name, surname, countryId) => {
        AuthorService.editAuthor(id, name, surname, countryId).then(this.getAuthors);
    }

    deleteAuthor = (id) => {
        AuthorService.deleteAuthor(id).then(this.getAuthors);
    }
    // endregion Author Service

    // region Country Service
    getCountries = () => {
        CountryService.getCountries().then(res => this.setState({countries: res.data}));
    }

    getCountryById = (id) => {
        CountryService.getCountryById(id).then(res => this.setState({selectedCountry: res.data}));
    }

    addCountry = (name, continent) => {
        CountryService.addCountry(name, continent).then(this.getCountries);
    }

    editCountry = (id, name, continent) => {
        CountryService.editCountry(id, name, continent).then(this.getCountries);
    }

    deleteCountry = (id) => {
        CountryService.deleteCountry(id).then(this.getCountries);
    }
    // endregion Country Service

    // region Category Service
    getCategories = () => {
        CategoryService.getCategories().then(res => this.setState({categories: res.data}));
    }
    // endregion Category Service
}
