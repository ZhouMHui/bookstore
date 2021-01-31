import axios from "axios"
export default{
    get_category(){
        return axios({
            method:'get',
            url:'http://localhost:8080/category/all',
        });
    },
    user_login(username, password) {
        return axios.get("http://localhost:8080/user/login?username=" + username + "&password=" + password);
    },
    get_books_by_name(name){
        return axios.get('http://localhost:8080/book/search?name='+name);
    },
    addbooktodb(book_id,user_id){
        return axios.get('http://localhost:8080/book/addbooktodb?book_id='+book_id+"&user_id="+user_id);
    },
    deletebooktodb(book_id,user_id){
        return axios.get('http://localhost:8080/book/deletebooktodb?book_id='+book_id+"&user_id="+user_id);
    },
    get_books_by_category(category){
        return axios.get('http://localhost:8080/book/getbook_categroy?category='+category);
    },
    get_book(id){
        return axios.get('http://localhost:8080/book/getbook_message?id='+id);
    },
    addbook(book_id,user_id){
        return axios.get('http://localhost:8080/book/addbook?book_id='+book_id+"&user_id="+user_id);
    },
    deletebook(book_id,user_id){
        return axios.get('http://localhost:8080/book/deletebook?book_id='+book_id+"&user_id="+user_id);
    },
    search_collection(user_id){
        return axios.get('http://localhost:8080/book/search_collection?user_id='+user_id);
    },
    state(book_id,user_id){
        return axios.get('http://localhost:8080/book/state?book_id='+book_id+"&user_id="+user_id);
    },
    get_bookmessage(){
        return axios({
            method:'get',
            url:'http://localhost:8080/book/all',
        });
    },
}