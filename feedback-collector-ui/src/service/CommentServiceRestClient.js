export const sendComment = async (comment) => {
    const response = await fetch("http://localhost:8090/feedback",
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(comment)
        });

    if (response.ok) {
        return comment;
    }
    throw new Error(response.toString());
};

export const loadComments = async () => {
    const response = await fetch("http://localhost:8090/feedback",
        {
            method: 'GET',
            headers: {
                'Accept': 'application/json'
            }
        });

    if (response.ok) {
        console.log("response .....")
        return response.json();
    }
    throw new Error(response.toString());
};
