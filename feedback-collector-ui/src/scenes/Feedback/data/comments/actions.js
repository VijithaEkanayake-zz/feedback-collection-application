import {sendComment} from "../../../../service/CommentServiceRestClient";
import {loadComments} from "../../../../service/CommentServiceRestClient";

export const ADD = 'Feedback/data/comments/ADD';
export const ADD_ALL = 'Feedback/data/comments/ADD_ALL';
export const ADD_FULFILLED = 'Feedback/data/comments/ADD_FULFILLED';
export const ADD_ALL_FULFILLED = 'Feedback/data/comments/ADD_ALL_FULFILLED';

export const add = payload =>
    (payload.name && payload.rating && payload.comment && ({
        type: ADD,
        payload: sendComment(payload)
			.catch((e => console.error("Error occurred while sending added comment", e)))
    }));

export const addAll = () => {
    return {
        type: ADD_ALL,
        payload:
			loadComments()
            .catch(e => console.error("Error occurred while loading comments", e))
    }
};
