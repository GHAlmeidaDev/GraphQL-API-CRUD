package com.ghdev.graphqlapi.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ghdev.graphqlapi.error.PostNotFoundException;
import com.ghdev.graphqlapi.model.Post;
import com.ghdev.graphqlapi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {

    private final PostRepository postRepository;

    public Post post(String id) {
        return postRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new PostNotFoundException("Post not found", id));
    }

    public Iterable<Post> allPosts() {
        return postRepository.findAll();
    }

}