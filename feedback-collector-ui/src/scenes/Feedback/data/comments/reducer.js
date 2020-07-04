import {ADD_ALL_FULFILLED, ADD_FULFILLED} from './actions';

const initialState = [];

export const reducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_FULFILLED:
            return [...state, action.payload];
        case ADD_ALL_FULFILLED:
            return [...state, ...action.payload];
        default:
            return state;
    }
};

export const getCommentsDesc = state => {
    const comments = [...state];
    comments.reverse();
    return comments;
};

export const getRating = state =>
    state.reduce((prev, current) => ({
        ...prev,
        [current.rating]: (prev[current.rating] || 0) + 1,
    }), {});
