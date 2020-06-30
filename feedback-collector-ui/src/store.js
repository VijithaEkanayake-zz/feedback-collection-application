import {createStore, compose, combineReducers, applyMiddleware} from 'redux';
import { reducer as feedbackReducer } from './scenes/Feedback/reducer';
import thunk from "redux-thunk";
import promise from "redux-promise-middleware";

const appReducer = combineReducers({
	Feedback: feedbackReducer,
});

export default createStore(
	appReducer,
	compose(
		window.devToolsExtension ? window.devToolsExtension() : f => f
	),
	applyMiddleware(thunk, promise)
);
