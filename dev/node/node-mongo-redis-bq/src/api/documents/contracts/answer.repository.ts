import { Injectable } from '@nestjs/common';
import { IRepository } from 'src/components/base/repository.base';
import { InjectRepository } from '@nestjs/typeorm';
import { MongoRepository } from 'typeorm';
import { AnswerDocument } from '../Answer.document';

@Injectable()
export class AnswerRepository implements IRepository<AnswerDocument> {

    constructor(
        @InjectRepository(AnswerDocument) private repository: MongoRepository<AnswerDocument>
    ) {
    }

    findAll(query?: any): Promise<AnswerDocument[]> {
        return this.repository.find(query);
    }

    create(document: AnswerDocument): Promise<AnswerDocument> {
        return this.repository.save(document);
    }

    findById(id: string): Promise<AnswerDocument> {
        return this.repository.findOne({
            where: { _id: id }
        })
    }

    findOne(query: any): Promise<AnswerDocument> {
        return this.repository.findOne({
            where: query
        })
    }

    update(id: string, document: AnswerDocument): Promise<any> {
        return this.repository.update(id, document);

    }

    remove(id: string): Promise<any> {
        return this.repository.delete(id);
    }
} 